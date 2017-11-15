package tictactoe;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class tictactoe {

    private JFrame frame;
    private JPanel Menu;
    private JPanel Play;
    private JPanel playVsComp;
    private JPanel HowToPlay;
    private JLabel title, explain,firstWon, secondWon, displayPlayer, displayComp;
    private JButton compR1c1, compR2c1, compR3c1, compR1c2, compR2c2, compR3c2 ,
   					 compR1c3, compR2c3, compR3c3;
	private static JButton counterX, counterO;
  
    //keep track of number of turn
    private int playerTurn = 1;
    private int compTurn = 1;
     
    //grid to store all values
    private static int [] pvp1 = new int [9];
    private static int [] pvp2 = new int [9];
    private static int [] playerGrid = new int [9];
    private static int [] compGrid = new int[9];
    
    //row&col to keep track if button are already pressed
    private int r1c1, r2c1 , r3c1 , r1c2 , r2c2 , r3c2 , r1c3 , r2c3, r3c3;
    private int cpR1c1, cpR2c1 , cpR3c1 , cpR1c2 , cpR2c2 , cpR3c2 , cpR1c3 , cpR2c3, cpR3c3;

    private int numXwin, numOwin, numWinPlay, numWinComp;
    
//    private int switchComp = 0;
    
    //win boolean to see if player won
    private static boolean xWin , oWin,  playerWin, compWin;
    private static boolean firstTimeWin = false;
//    private static boolean firstWinComp = false;
   
    
    
    private static int p1WinCount, p2WinCount;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
   	 EventQueue.invokeLater(new Runnable() {
   		 public void run() {
   			 try {   				 
   				 tictactoe window = new tictactoe();    
   				 window.frame.setVisible(true);
   							 
   			 } catch (Exception e) {
   				 e.printStackTrace();
   			 }
   		 }
   	 });
    }
    
    /**
     * Create the application.
     */
    public tictactoe() {
   	 
   	 initialize();
   	 
    }

    public static void setCounters() {
    	String numX = Integer.toString(p1WinCount);
    	counterX.setText(numX);
    	
    	String numO = Integer.toString(p2WinCount);
    	counterO.setText(numO);
    	
    }
    
    public static boolean checkWinPvP(){
   		 //======================Winning message======================
    	
    
    if(!firstTimeWin){
   		 
  		 //for horizontal win first player
  		 if(pvp2[0] == 1 && pvp2[1] == 1 && pvp2[2]==1 ||
  				 pvp2[3] == 1 && pvp2[4] == 1 && pvp2[5] == 1 ||
  				 pvp2[6] == 1 && pvp2[7] == 1 && pvp2[8] == 1){
  			 System.out.println("The first player won! horizontal");
  			 oWin = true;
  			 firstTimeWin = true;
  			 p1WinCount++;
  			 setCounters();
  			 return true;
  		 }
  		 //for vertical win first player
  		 else if(pvp2[0] == 1 && pvp2[3] == 1 && pvp2[6] == 1 ||
  				 pvp2[1] == 1 && pvp2[4] == 1 && pvp2[7] == 1 ||
  				 pvp2[2] == 1 && pvp2[5] == 1 && pvp2[8] == 1){
  			 System.out.println("The first player won! vertical");
  			 oWin = true;
  			 firstTimeWin = true;
  			 p1WinCount++;
  			 setCounters();
  			 return true;
  		 }
  		 //for diagonal first player
  		 else if(pvp2[0] == 1 && pvp2[4] == 1 && pvp2[8] == 1||
  				 pvp2[2] == 1 && pvp2[4] == 1 && pvp2[6] == 1){
  			 System.out.println("The first player won! diagonal");
  			 oWin = true;
  			 firstTimeWin = true;
  			 p1WinCount++;
  			 setCounters();
  			 return true;
  		 }
    	
   	   	//For horizontal win second player
   		 if(pvp1[0] == 1 && pvp1[1] == 1 && pvp1[2] ==1 ||
   				 pvp1[3] == 1 && pvp1[4] == 1 && pvp1[5] == 1 ||
   				 pvp1[6] == 1 && pvp1[7] == 1 && pvp1[8] == 1 ){
   			 System.out.println("The second player won! horizontal");
   			 xWin = true;
   			 firstTimeWin = true;
   			 p2WinCount++;
   			 setCounters();
   			 return true;
   		 }
   		 // for vertical win second player
   		 else if(pvp1[0] == 1 && pvp1[3] == 1 && pvp1[6] == 1 ||
   				 pvp1[1] == 1 && pvp1[4] == 1 && pvp1[7] == 1 ||
   				 pvp1[2] == 1 && pvp1[5] == 1 && pvp1[8] == 1){
   			 System.out.println("The second player won! vertical");
   			 xWin = true;
   			 firstTimeWin = true;
   			 p2WinCount++;
   			 setCounters();
   			 return true;
   		 }
   		 //for diagonal win second player
   		 else if(pvp1[0] == 1 && pvp1[4] == 1 && pvp1[8] == 1||
   				 pvp1[2] == 1 && pvp1[4] == 1 && pvp1[6] == 1){
   			 System.out.println("The second player won! diagonal");
   			 xWin = true;
   			 firstTimeWin = true;
   			 p2WinCount++;
   			 setCounters();
   			 return true;
   		 
   		 }   	 
   	 }   			 
   		 //return false if player did not win
   		 return false;
   	 }
    
    
    public static boolean checkWinPvC(){
   	 
   	 
   	 //for horizontal - computer
   	 if(compGrid[0] == 1 && compGrid[1] == 1 && compGrid[2] ==1 ||
   			 compGrid[3] == 1 && compGrid[4] == 1 && compGrid[5] == 1 ||
   			 compGrid[6] == 1 && compGrid[7] == 1 && compGrid[8] == 1 ){
   		 
   		 
   		 compWin = true;
   		 System.out.println("The computer won by horizontal");
   		return true;
   	 }
   	 
   	 //for vertical - computer
   	 else if(compGrid[0] == 1 && compGrid[3] == 1 && compGrid[6] == 1 ||
   				 compGrid[1] == 1 && compGrid[4] == 1 && compGrid[7] == 1 ||
   				 compGrid[2] == 1 && compGrid[5] == 1 && compGrid[8] == 1){
   	 
   		compWin = true;
   		System.out.println("The computer won by vertical"); 
   		return true;
   	 }
   	 // for diagonal - computer
   	 else if(compGrid[0] == 1 && compGrid[4] == 1 && compGrid[8] == 1||
   			compGrid[2] == 1 && compGrid[4] == 1 && compGrid[6] == 1) {
   		 
   		 
   		compWin = true;
   		 System.out.println("The computer won by diagonal");
   		return true;
   	 }
   	 
   	 
   	 //for horizontal - player
   	 if(playerGrid[0] == 1 && playerGrid[1] == 1 && playerGrid[2] ==1 ||
   				playerGrid[3] == 1 && playerGrid[4] == 1 && playerGrid[5] == 1 ||
   				playerGrid[6] == 1 && playerGrid[7] == 1 && playerGrid[8] == 1 ){
   		 
   		 
   		 playerWin = true;
   		 System.out.println("The player won by horizontal");
   		return true;
   	 }
   	 
   	 //for vertical - player
   	 else if(playerGrid[0] == 1 && playerGrid[3] == 1 && playerGrid[6] == 1 ||
   			 	playerGrid[1] == 1 && playerGrid[4] == 1 && playerGrid[7] == 1 ||
   				playerGrid[2] == 1 && playerGrid[5] == 1 && playerGrid[8] == 1){
   	 
   		playerWin = true;
   		System.out.println("The player won by vertical"); 
   		return true;
   	 }
   	 // for diagonal - player
   	 else if(playerGrid[0] == 1 && playerGrid[4] == 1 && playerGrid[8] == 1||
   			playerGrid[2] == 1 && playerGrid[4] == 1 && playerGrid[6] == 1) {
   		 
   		 
   		playerWin = true;
   		 System.out.println("The player won by diagonal");
   		return true;
   	 }
  
   	 
   	 
   	 return false;
   	 
    }
    
    //computer select which tile to turn
    public void compSelect(int x){
   	 
   	 System.out.println("computer turn "+compTurn + "\n");
   	 
   	 boolean continuation = true;
   	 while(continuation){
   	 
   			 if(compR1c1.getText() == "" && x == 1 && cpR1c1 == 0){
   				 compR1c1.setText("O");
   				 compR1c1.setForeground(Color.BLUE);
   				 compTurn++;
   				 cpR1c1 = 1;
   				 compGrid[0] = 1;
   				 continuation = false;
   			 }
   			 else if(compR2c1.getText() == "" && x == 2 && cpR2c1 == 0){
   				 compR2c1.setText("O");
   				 compR2c1.setForeground(Color.BLUE);
   				 compTurn++;
   				 cpR2c1 = 1;
   				 compGrid[1] = 1;
   				 continuation = false;
    
   			 }
   			 else if(compR3c1.getText() == "" && x == 3 && cpR3c1 == 0){
   				 compR3c1.setText("O");
   				 compR3c1.setForeground(Color.BLUE);
   				 compTurn++;
   				 cpR3c1 = 1;
   				 compGrid[2] = 1;
   				 continuation = false;
   			 }
   						 
   			 
   			 else if(compR1c2.getText() == "" && x == 4 && cpR1c2 == 0){
   				 compR1c2.setText("O");
   				 compR1c2.setForeground(Color.BLUE);
   				 compTurn++;
   				 cpR1c2 = 1;
   				 compGrid[3] = 1;
   				 continuation = false;

   			 }
   			 else if(compR2c2.getText() == "" && x == 5 && cpR2c2 == 0){
   				 compR2c2.setText("O");
   				 compR2c2.setForeground(Color.BLUE);
   				 compTurn++;
   				 cpR2c2 = 1;
   				 compGrid[4] = 1;
   				 continuation = false;

   			 }
   			 else if(compR3c2.getText() == "" && x == 6 && cpR3c2 == 0)
   			 {
   				 compR3c2.setText("O");
   				 compR3c2.setForeground(Color.BLUE);
   				 compTurn++;
   				 cpR3c2 = 1;
   				 compGrid[5] = 1;
   				 continuation = false;

   			 }
   			 
   						 
   			 else if(compR1c3.getText() == "" && x == 7 && cpR1c3 == 0)
   			 {
   				 compR1c3.setText("O");
   				 compR1c3.setForeground(Color.BLUE);
   				 compTurn++;
   				 cpR1c3 = 1;
   				 compGrid[6] = 1;
   				 continuation = false;

   			 }
   			 else if(compR2c3.getText() == "" && x == 8 && cpR2c3 == 0){
   				 compR2c3.setText("O");
   				 compR2c3.setForeground(Color.BLUE);
   				 compTurn++;
   				 cpR2c3 = 1;
   				 compGrid[7] = 1;
   				 continuation = false;

   			 }
   			 else if(compR3c3.getText() == "" && x == 9 && cpR3c3 == 0){
   				 compR3c3.setText("O");
   				 compR3c3.setForeground(Color.BLUE);
   				 compTurn++;
   				 cpR3c3 = 1;
   				 compGrid[8] = 1;
   				 continuation = false;

   			 }
   			 else {
   			 Random rand = new Random();
   			 x = rand.nextInt(9) +1;
   			 System.out.println(x);

   			 }
   	 }
    }
    
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
   	 frame = new JFrame("Tic Tac Toe");
   	 frame.setBounds(100, 100, 450, 300);
   	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 frame.getContentPane().setLayout(new CardLayout(0, 0));
   	 
   	 frame.setSize(651,500);
   	 frame.setResizable(false);
   	 //==========================MENU==========================
   	 
   	 Menu = new JPanel();
   	 Menu.setBackground(Color.LIGHT_GRAY);
   	 Menu.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));
   	 frame.getContentPane().add(Menu, "name_57682631491580");
   	 Menu.setLayout(null);
   	 Menu.setVisible(true);
   	 
//   	ImageIcon image = new ImageIcon("tictactoe/thinkOutside.jpg");
//   	JLabel label = new JLabel("", image, JLabel.CENTER);
//   	JPanel panel = new JPanel(new BorderLayout());
//   	panel.add( label, BorderLayout.CENTER );
   	 
   	 
   	 //==============================PLAY===========================
   			 
   			 Play = new JPanel();
   			 Play.setBackground(Color.LIGHT_GRAY);
   			 frame.getContentPane().add(Play, "name_57685129994922");
   			 Play.setLayout(null);   			 
   			 
   			 //set players variable to keep track
//   			 int player1 = 1;
//   			 int player2  = 2;
   						 
   			 firstWon = new JLabel();
   			 firstWon.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 secondWon = new JLabel();
   			 secondWon.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 
   			 String player2Win = "Congratulation! second player [O] won the game";
   			 String player1Win = "Congratulation! first player [X] won the game!";
   			 firstWon.setText("<html>" + player2Win+"</html>");
   			 firstWon.setBounds(125, 294, 154, 187);
   			 
   			 secondWon.setText("<html>" + player1Win + "</html>");
   			 secondWon.setBounds(125, 288, 213, 171);
   			 
   			 Play.add(firstWon);
   			 Play.add(secondWon);
   			 
   			 firstWon.setVisible(false);
   			 secondWon.setVisible(false);
   			 
   			 
   			 JLabel lblPlayerX = new JLabel("Player X");
   			 lblPlayerX.setBounds(416, 74, 69, 20);
   			 Play.add(lblPlayerX);
   			 
   			 JLabel lblPlayerO = new JLabel("Player O");
   			 lblPlayerO.setBounds(542, 74, 69, 20);
   			 Play.add(lblPlayerO);
   			 
   			 counterX = new JButton("0");
   			 counterX.addActionListener(new ActionListener() {
   			 	public void actionPerformed(ActionEvent e) {
   			 	}
   			 });
   			 
   			 counterX.setBounds(389, 110, 115, 29);
   			 Play.add(counterX);
   			 
   			 counterO = new JButton("0");
   			
   			 counterO.setBounds(515, 110, 115, 29);
   			 Play.add(counterO);
   			 
   			 
   			 JButton btnr1c1 = new JButton("");
   			 btnr1c1.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			
   			 btnr1c1.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 //if not clicked then print X or O
   					 //player 2 if turn is even
   					 // player = "0" || computer = "X"
   										 
   						 if(playerTurn%2 == 0 && r1c1 == 0){
   							 btnr1c1.setText("O");
   							 btnr1c1.setForeground(Color.BLUE);
   							 
   							 //increment the turn
   							 playerTurn++;
   							 r1c1 = 1;
   							 pvp1[0] = 1;			 
   						 }
   						 // if player 1 is odd
   						 else if(playerTurn%2 == 1 && r1c1 == 0){
   							 //change the button text
   							 btnr1c1.setText("X");
   							 btnr1c1.setForeground(Color.RED);
   							 
   							 r1c1 = 1;
   							 //increment the turn
   							 playerTurn++;
   							 pvp2[0] = 1;
   						 }   		 

   						 //display a winning message into panel
   						 if(checkWinPvP()){
   							 
   							 if(xWin)
   								 firstWon.setVisible(true);
   							 else if(oWin)
   								 secondWon.setVisible(true);
   						 
   						 }
   					 
   					 //***********
   						 System.out.println("r1c1 " + playerTurn + "play[0]:" + pvp1[0] + " comp:" + pvp2[0]);
   					 //***********
   				 }
   			 });
   			 btnr1c1.setBounds(33, 99, 119, 71);
   			 Play.add(btnr1c1);
   			 
   			 JButton btnr2c1 = new JButton("");
   			 btnr2c1.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 btnr2c1.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 //if not clicked then print X or O
   					 //player 2 if turn is even
   										 
   						 if(playerTurn%2 == 0 && r2c1 == 0){
   							 btnr2c1.setText("O");
   							 btnr2c1.setForeground(Color.BLUE);
   							 
   							 r2c1 = 1;
   							 //increment the turn
   							 playerTurn++;
   							 pvp1[3] = 1;
   						 }
   						 // is player 1 if odd
   						 else if (playerTurn%2 == 1 && r2c1 == 0){
   							 //change the button text
   							 btnr2c1.setText("X");
   							 btnr2c1.setForeground(Color.RED);
   							 r2c1 = 1;
   							 //increment the turn
   							 playerTurn++;
   							 pvp2[3] = 1;
   						 }
   					 
   						 //display a winning message into panel
   						 if(checkWinPvP()){
    
   							 if(xWin)
   								 firstWon.setVisible(true);
   							 else if(oWin)
   								 secondWon.setVisible(true);
   						 
   						 }
   						 
   					 //***********
   						 System.out.println("r2c1 " + playerTurn + "play[3]:" + pvp1[3] + " comp:" + pvp2[3]);
   					 //***********
   				 }
   			 });
   			 btnr2c1.setBounds(33, 171, 119, 72);
   			 Play.add(btnr2c1);
   			 
   			 JButton btnr3c1 = new JButton("");
   			 btnr3c1.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 btnr3c1.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 //if not clicked then print X or O
   					 //player 2 if turn is even
   								 
   					 if(playerTurn%2 == 0 && r3c1 == 0){
   						 btnr3c1.setText("O");
   						 btnr3c1.setForeground(Color.BLUE);
   						 r3c1 = 1;
   						 //increment the turn
   						 playerTurn++;
   						 pvp1[6] = 1;
   					 }
   					 // is player 1 if odd
   					 else if(playerTurn%2 == 1 && r3c1 == 0){
   						 //change the button text
   						 btnr3c1.setText("X");
   						 btnr3c1.setForeground(Color.RED);
   						 r3c1 = 1;
   						 //increment the turn
   						 playerTurn++;    
   						 pvp2[6] = 1;
   					 }
   					 
   					 //display a winning message into panel
   					 if(checkWinPvP()){

   						 if(xWin)
   							 firstWon.setVisible(true);
   						 else if(oWin)
   							 secondWon.setVisible(true);
   					 }
   					 
   					 //***********
   					 System.out.println("r3c1 " + playerTurn + "play[6]:" + pvp1[6] + " comp:" + pvp2[6]);
   					 //***********
   					 
   				 }
   			 });
   			 btnr3c1.setBounds(33, 246, 119, 71);
   			 Play.add(btnr3c1);
   			 
   			 JButton btnr1c2 = new JButton("");
   			 btnr1c2.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 btnr1c2.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 //if not clicked then print X or O
   					 //player 2 if turn is even
   								 
   					 if(playerTurn%2 == 0 && r1c2 == 0){
   						 btnr1c2.setText("O");
   						 btnr1c2.setForeground(Color.BLUE);
   						 //increment the turn
   						 playerTurn++;
   						 r1c2 = 1;
   						 pvp1[1] = 1;
   						 
   					 }
   					 // is player 1 if odd
   					 else if(playerTurn%2 == 1 && r1c2 == 0){
   						 //change the button text
   						 btnr1c2.setText("X");
   						 btnr1c2.setForeground(Color.RED);
   						 //increment the turn
   						 playerTurn++;
   						 r1c2 = 1;
   						 pvp2[1] = 1;
   					 }

   					 //display a winning message into panel
   					 //display a winning message into panel
   					 if(checkWinPvP()){

   						 if(xWin)
   							 firstWon.setVisible(true);
   						 else if(oWin)
   							 secondWon.setVisible(true);
   					 }
   					 
   					 //***********
   					 System.out.println("r1c2 " + playerTurn + "play[1]:" + pvp1[1] + " comp:" + pvp2[1]);
   					 //***********
   				 }
   			 });
   			 btnr1c2.setBounds(153, 99, 111, 71);
   			 Play.add(btnr1c2);
   			 
   			 JButton btnr2c2 = new JButton("");
   			 btnr2c2.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 btnr2c2.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 //if not clicked then print X or O
   					 //player 2 if turn is even
   					 
   					 if(playerTurn%2 == 0 && r2c2 == 0){
   						 btnr2c2.setText("O");
   						 btnr2c2.setForeground(Color.BLUE);
   						 //increment the turn
   						 playerTurn++;
   						 r2c2 = 1;
   						 pvp1[4] = 1;
   					 }
   					 // is player 1 if odd
   					 else if(playerTurn%2 == 1 && r2c2 == 0){
   						 //change the button text
   						 btnr2c2.setText("X");
   						 btnr2c2.setForeground(Color.RED);					 
   						 //increment the turn
   						 playerTurn++;
   						 r2c2 = 1;
   						 pvp2[4] = 1;
   					 }
   					 
   					 //display a winning message into panel
   					 if(checkWinPvP()){

   						 if(xWin)
   							 firstWon.setVisible(true);
   						 else if(oWin)
   							 secondWon.setVisible(true);
   					 }
   					 
   					 //***********
   					 System.out.println("r2c2 " + playerTurn + "play[4]:" + pvp1[4] + " comp:" + pvp2[4]);
   					 //***********
   				 }
   			 });
   			 btnr2c2.setBounds(153, 171, 111, 72);
   			 Play.add(btnr2c2);
   			 
   			 JButton btnr3c2 = new JButton("");
   			 btnr3c2.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 btnr3c2.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 //if not clicked then print X or O
   					 //player 2 if turn is even
   					 
   					 if(playerTurn%2 == 0 && r3c2 == 0){
   						 btnr3c2.setText("O");
   						 btnr3c2.setForeground(Color.BLUE);
   						 //increment the turn
   						 playerTurn++;
   						 r3c2 = 1;
   						 pvp1[7] = 1;
   					 }
   					 //player 1 if odd
   					 else if(playerTurn%2 == 1 && r3c2 == 0){
   						 //change the button text
   						 btnr3c2.setText("X");
   						 btnr3c2.setForeground(Color.RED);
   						 //increment the turn
   						 playerTurn++;
   						 r3c2 = 1;
   						 pvp2[7] = 1;
   					 }
   				 
   					 //display a winning message into panel
   					 if(checkWinPvP()){

   						 if(xWin)
   							 firstWon.setVisible(true);
   						 else if(oWin)
   							 secondWon.setVisible(true);
   					 }
   					 
   					 //***********
   					 System.out.println("r3c2 " + playerTurn + "play[7]:" + pvp1[7] + " comp:" + pvp2[7]);
   					 //***********
   				 }
   			 });
   			 btnr3c2.setBounds(152, 246, 112, 71);
   			 Play.add(btnr3c2);
   					 
   			 JButton btnr1c3 = new JButton("");
   			 btnr1c3.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 btnr1c3.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 //if not clicked then print X or O
   					 //player 2 if turn is even
   					 
   					 if(playerTurn%2 == 0 && r1c3 == 0){
   						 btnr1c3.setText("O");
   						 btnr1c3.setForeground(Color.BLUE);
   						 //increment the turn
   						 playerTurn++;
   						 r1c3 = 1;
   						 pvp1[2] = 1;
   					 }
   					 //player 1 if odd
   					 else if(playerTurn%2 == 1 && r1c3 == 0){
   						 //change the button text
   						 btnr1c3.setText("X");
   						 btnr1c3.setForeground(Color.RED);
   						 //increment the turn
   						 playerTurn++;
   						 r1c3 = 1;
   						 pvp2[2] = 1;
   					 }
   				 
   					 //display a winning message into panel
   					 if(checkWinPvP()){

   						 if(xWin)
   							 firstWon.setVisible(true);
   						 else if(oWin)
   							 secondWon.setVisible(true);
   					 }
   					 
   					 //***********
   					 System.out.println("r1c3 " + playerTurn + "play[2]:" + pvp1[2] + " comp:" + pvp2[2]);
   					 //***********
   				 }
   			 });
   			 
   			 btnr1c3.setBounds(266, 99, 108, 71);
   			 Play.add(btnr1c3);
   			 
   			 JButton btnr2c3 = new JButton("");
   			 btnr2c3.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 btnr2c3.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 //if not clicked then print X or O
   					 //player 2 if turn is even
   				 
   					 if(playerTurn%2 == 0 && r2c3 == 0){
   						 btnr2c3.setText("O");
   						 btnr2c3.setForeground(Color.BLUE);
   						 
   						 //increment the turn
   						 playerTurn++;
   						 r2c3 = 1;
   						 pvp1[5] = 1;
   					 }
   					 // is player 1 if odd
   					 else if(playerTurn%2 == 1 && r2c3 == 0){
   						 //change the button text
   						 btnr2c3.setText("X");
   						 btnr2c3.setForeground(Color.RED);
   						 
   						 //increment the turn
   						 playerTurn++;
   						 r2c3 = 1;
   						 pvp2[5] = 1;
   					 }
   				 
   					 //display a winning message into panel
   					 if(checkWinPvP()){

   						 if(xWin)
   							 firstWon.setVisible(true);
   						 else if(oWin)
   							 secondWon.setVisible(true);
   					 }
   					 
   					 //***********
   					 System.out.println("r2c3 " + playerTurn + "play[5]:" + pvp1[5] + " comp:" + pvp2[5]);
   					 //***********
   					 
   				 }
   			 });
   			 btnr2c3.setBounds(266, 171, 108, 71);
   			 Play.add(btnr2c3);
   			 
   			 JButton btnr3c3 = new JButton("");
   			 btnr3c3.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 btnr3c3.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 //if not clicked then print X or O
   					 //player 2 if turn is even   		 
   					 
   					 if(playerTurn%2 == 0 && r3c3 == 0){
   						 btnr3c3.setText("O");
   						 btnr3c3.setForeground(Color.BLUE);
   						 
   						 //increment the turn
   						 playerTurn++;
   						 r3c3 = 1;
   						 pvp1[8] = 1;
   					 }
   					 // is player 1 if odd
   					 else if(playerTurn%2 == 1 && r3c3 == 0){
   						 //change the button text
   						 btnr3c3.setText("X");
   						 btnr3c3.setForeground(Color.RED);
   						 
   						 //increment the turn
   						 playerTurn++;
   						 r3c3 = 1;
   						 pvp2[8] = 1;
   					 }
   				 
   					 //display a winning message into panel
   					 if(checkWinPvP()){

   						 if(xWin) {
   							 firstWon.setVisible(true);
   							numXwin+=1;
   							String print = Integer.toString(numXwin);
   							counterX.setText(print);
   							System.out.println("x won");
   						 }
   						 else if(oWin) {
   							 secondWon.setVisible(true);
   							numOwin+=1;
   							String print = Integer.toString(numOwin);
   							counterO.setText(print);
   							System.out.println("o won");
   						 }
   					 }
   					 
   					 //***********
   					 System.out.println("r3c3 " + playerTurn + "play[8]:" + pvp1[8] + " comp:" + pvp2[8]);
   					 //***********
   					 
   				 }
   			 });
   			 btnr3c3.setBounds(266, 246, 108, 71);
   			 Play.add(btnr3c3);
   		 
   			 JButton btnMainMenu = new JButton("");
   			 btnMainMenu.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\mainMenu.jpg"));
   			 btnMainMenu.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 Menu.setVisible(true);
   					 Play.setVisible(false);
   				 }
   			 });
   			 btnMainMenu.setBounds(515, 348, 80, 80);
   			 Play.add(btnMainMenu);
   			 
   			 //reset all variables to default to restart the frame
   			 JButton btnRestart = new JButton("");
   			 btnRestart.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\restartBtn.png"));
   			 btnRestart.addActionListener(new ActionListener(){
   				 public void actionPerformed(ActionEvent e)
   				 {
   					 //set label to invisible
   					 firstWon.setVisible(false);
   					 secondWon.setVisible(false);
   					    					 
   					 firstTimeWin = false;
   					 
   					 //set all button text to blank
   					 btnr1c1.setText("");
   					 btnr2c1.setText("");
   					 btnr3c1.setText("");
   					 
   					 btnr1c2.setText("");
   					 btnr2c2.setText("");
   					 btnr3c2.setText("");
   					 
   					 btnr1c3.setText("");
   					 btnr2c3.setText("");
   					 btnr3c3.setText("");
   					 
   					 //set row & cols value to 0
   					 r1c1 = r2c1 = r3c1 = r1c2 = r2c2 = r3c2 = r1c3 = r2c3 = r3c3 = 0;
   				 
   					 //set grid of players to 0
   					 pvp1[0] = pvp1[1] = pvp1[2] = pvp1[3] =
   						 pvp1[4] = pvp1[5] = pvp1[6] = pvp1[7] = pvp1[8]= 0;
   				 
   					 pvp2[0] = pvp2[1] = pvp2[2] = pvp2[3] =
   						 pvp2[4] = pvp2[5] = pvp2[6] = pvp2[7] = pvp2[8]= 0;
   					 playerTurn = 1;
   				 }
   				 
   			 });
   			 
   			 btnRestart.setBounds(476,271,119,46);
   			 Play.add(btnRestart);
   			 
   			 JLabel lblNewLabel_1 = new JLabel("Game");
   			 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
   			 lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 40));
   			 lblNewLabel_1.setBounds(101, 16, 212, 45);
   			 Play.add(lblNewLabel_1);
   			 Play.setVisible(false);
   			 
   	 //===================End of Play============================   		 
   			 
   	 //===================player vs computer======================   	 
   			 
   			 Random rand = new Random();
   			 
   			 JPanel play_comp = new JPanel();
   			 play_comp.setBackground(Color.LIGHT_GRAY);
   			 frame.getContentPane().add(play_comp, "name_59685129994900");
   			 play_comp.setLayout(null);    
			 
   			 displayPlayer = new JLabel();
   			 displayPlayer.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 displayComp = new JLabel();
   			 displayComp.setFont(new Font("Tahoma", Font.PLAIN, 20));
   			 secondWon.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 
   			 JLabel lblNewLabel_3 = new JLabel("");
   			 lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\bgTic.jpg"));
   			 lblNewLabel_3.setBounds(0, 0, 645, 459);
   			 Play.add(lblNewLabel_3);
   			 
   			 String playWonTxt = "Congratulation! You manage to beat the computer";
   			 String compWonTxt = "oh no! The computer beat you, shame on you";
   			
   			 displayPlayer.setText("<html>" + playWonTxt +"</html>");
   			 displayPlayer.setBounds(446, 38, 154, 187);
   			 
   			 displayComp.setText("<html>" + compWonTxt + "</html>");
   			 displayComp.setBounds(417, 54, 213, 171);
   			 
   			 play_comp.add(displayPlayer);
   			 play_comp.add(displayComp);
   			 
   			 displayPlayer.setVisible(false);
   			 displayComp.setVisible(false);
   			 
   			 //===================Button===============
   			 
   			 //  X|+|+
   			 //  +|+|+
   			 //  +|+|+
   			 compR1c1 = new JButton("");
   			 compR1c1.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 compR1c1.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 //if clicked then set button to "X"
   					 //if it's not already pressed then change to x
   					 if(cpR1c1 == 0) {
   					 compR1c1.setText("X");
   					 compR1c1.setForeground(Color.RED);
   					 playerGrid[0] = 1;
   					 }
   					 
   					 if(compTurn <5 && cpR1c1 == 0){
   					 int randNum = rand.nextInt(9) +1;
   					 System.out.println("The random number is " + randNum);
   					 compSelect(randNum);
   					 cpR1c1 = 1;
   					 }
   					 
   					 if(checkWinPvC()) {
   						 if(playerWin)
   							displayPlayer.setVisible(true);
   						 else if(compWin)
   							 displayComp.setVisible(true);
   					 } 
   				 }
   				 
   			 });
   			 compR1c1.setBounds(42, 60, 121, 86);
   			 play_comp.add(compR1c1);
   			 
   			 //  +|+|+
   			 //  X|+|+
   			 //  +|+|+   			 
   			 compR2c1 = new JButton("");
   			 compR2c1.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 compR2c1.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 
   					 if(cpR2c1 == 0) {
   					 compR2c1.setText("X");
   					compR2c1.setForeground(Color.RED);
   					 playerGrid[1] = 1;
   					 }
   					 
   					 
   					 if(compTurn <5 && cpR2c1 == 0){
   						 int randNum = rand.nextInt(9) +1;
   						 System.out.println("The random number is " + randNum);
   						 compSelect(randNum);
   						 cpR2c1 = 1;
   							 }
   					 
   					if(checkWinPvC()) {
						 if(playerWin)
							displayPlayer.setVisible(true);
						 else if(compWin)
							 displayComp.setVisible(true);
					 }
   						 }
   			 });
   			 compR2c1.setBounds(42, 149, 121, 90);
   			 play_comp.add(compR2c1);
   						 
   			 //  +|+|+
   			 //  +|+|+
   			 //  X|+|+
   			 compR3c1 = new JButton("");
   			 compR3c1.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 compR3c1.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 
   					 if(cpR3c1 == 0) {
   					 compR3c1.setText("X");
   					 compR3c1.setForeground(Color.RED);
   					 playerGrid[2] = 1;
   					 }
   					 
   					 
   					 if(compTurn <5 && cpR3c1 == 0){
   						 int randNum = rand.nextInt(9) +1;
   						 System.out.println("The random number is " + randNum);
   						 compSelect(randNum);
   						 cpR3c1 = 1;    
   							 }
   					 
   					 
	   					if(checkWinPvC()) {
							 if(playerWin)
								displayPlayer.setVisible(true);
							 else if(compWin)
								 displayComp.setVisible(true);
						 }

   					 
   					 
   						 }
   			 });
   			 compR3c1.setBounds(42, 241, 121, 95);
   			 play_comp.add(compR3c1);   	 
   			 
   			 //  +|X|+
   			 //  +|+|+
   			 //  +|+|+
   			 compR1c2 = new JButton("");
   			 compR1c2.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 compR1c2.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 
   					 if(cpR1c2 == 0) {
   					 compR1c2.setText("X");
   					 compR1c2.setForeground(Color.RED);
   					 playerGrid[3] = 1;
   					 }
   					 
   					 
   					 if(compTurn <5 && cpR1c2 == 0){
   						 int randNum = rand.nextInt(9) +1;
   						 System.out.println("The random number is " + randNum);
   						 compSelect(randNum);
   						 cpR1c2 = 1;    
   							 }
   					 
	   					 
	   					if(checkWinPvC()) {
	
							 if(playerWin)
								displayPlayer.setVisible(true);
							 else if(compWin)
								 displayComp.setVisible(true);
						 }

   						 }
   			 });
   			 compR1c2.setBounds(168, 60, 120, 86);
   			 play_comp.add(compR1c2);
   			 
   			 //  +|+|+
   			 //  +|X|+
   			 //  +|+|+
   			 compR2c2 = new JButton("");
   			 compR2c2.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 compR2c2.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 
   					 if(cpR2c2 == 0) {
   					 compR2c2.setText("X");
   					 compR2c2.setForeground(Color.RED);
   					 playerGrid[4] = 1;
   					 
   					 }
   					 
   					 if(compTurn <5 && cpR2c2 == 0){
   						 int randNum = rand.nextInt(9) +1;
   						 System.out.println("The random number is " + randNum);
   						 compSelect(randNum);
   						 cpR2c2 = 1;    
   							 }
   					 
   					 
	   					if(checkWinPvC()) {
	
							 if(playerWin)
								displayPlayer.setVisible(true);
							 else if(compWin)
								 displayComp.setVisible(true);
						 }

   					 
   						 }
   			 });
   			 compR2c2.setBounds(168, 149, 120, 90);
   			 play_comp.add(compR2c2);

   			 
   			 //  +|+|+
   			 //  +|+|+
   			 //  +|X|+
   			 compR3c2 = new JButton("");
   			 compR3c2.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 compR3c2.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 
   					 if(cpR3c2 == 0) {
   					 compR3c2.setText("X");
   					 compR3c2.setForeground(Color.RED);
   					 playerGrid[5] = 1;
   					 
   					 }
   					 
   					 if(compTurn <5 && cpR3c2 == 0){
   						 int randNum = rand.nextInt(9) +1;
   						 System.out.println("The random number is " + randNum);
   						 compSelect(randNum);
   						 cpR3c2 = 1;    
   							 }
   					 
   					 
   					 
	   					if(checkWinPvC()) {
	
							 if(playerWin)
								displayPlayer.setVisible(true);
							 else if(compWin)
								 displayComp.setVisible(true);
						 }
   					}
   			 });
   			 compR3c2.setBounds(167, 241, 121, 95);
   			 play_comp.add(compR3c2);

   			 //  +|+|X
   			 //  +|+|+
   			 //  +|+|+
   			 compR1c3 = new JButton("");
   			 compR1c3.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 compR1c3.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 
   					 if(cpR1c3 == 0) {
   					 compR1c3.setText("X");
   					 compR1c3.setForeground(Color.RED);
   					 playerGrid[6] = 1;
   					 
   					 }
   					 
   					 if(compTurn <5 && cpR1c3 == 0){
   						 int randNum = rand.nextInt(9) +1;
   						 System.out.println("The random number is " + randNum);
   						 compSelect(randNum);
   						 cpR1c3 = 1;    
   							 }
   					 
   					if(checkWinPvC()) {
   						
						 if(playerWin)
							displayPlayer.setVisible(true);
						 else if(compWin)
							 displayComp.setVisible(true);
					 }
   					 
   					 
   						 }
   			 });
   			 compR1c3.setBounds(291, 60, 121, 86);
   			 play_comp.add(compR1c3);

   			 //  +|+|+
   			 //  +|+|X
   			 //  +|+|+
   			 compR2c3 = new JButton("");
   			 compR2c3.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 compR2c3.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 
   					 if(cpR2c3 == 0) {
   					 compR2c3.setText("X");
   					 compR2c3.setForeground(Color.RED);
   					 playerGrid[7] = 1;
   					 
   					 }
   					 
   					 
   					 if(compTurn <5 && cpR2c3 == 0){
   						 int randNum = rand.nextInt(9) +1;
   						 System.out.println("The random number is " + randNum);
   						 compSelect(randNum);
   						 cpR2c3 = 1;    
   							 }
   					 
   					 
	   					if(checkWinPvC()) {
	
							 if(playerWin)
								displayPlayer.setVisible(true);
							 else if(compWin)
								 displayComp.setVisible(true);
						 }

   					 
   					 
   					 
   						 }
   			 });
   			 compR2c3.setBounds(291, 149, 121, 90);
   			 play_comp.add(compR2c3);
   			 
   			 //  +|+|+
   			 //  +|+|+
   			 //  +|+|X
   			 compR3c3 = new JButton("");
   			 compR3c3.setFont(new Font("Tahoma", Font.PLAIN, 22));
   			 compR3c3.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 
   					 if(cpR3c3 == 0) {
   					 compR3c3.setText("X");
   					 compR3c3.setForeground(Color.RED);
   					 playerGrid[8] = 1;
   					
   					 }
   					 
   					 if(compTurn <5 && cpR3c3 == 0){
   						 int randNum = rand.nextInt(9) +1;
   						 System.out.println("The random number is " + randNum);
   						 compSelect(randNum);
   						 cpR3c3 = 1;    
   							 }
   					 
   					 
   					 
	   					if(checkWinPvC()) {
	
							 if(playerWin)
								displayPlayer.setVisible(true);
							 else if(compWin)
								 displayComp.setVisible(true);
						 }

   					 
   					 
   						 }
   			 });
   			 compR3c3.setBounds(291, 241, 121, 95);
   			 play_comp.add(compR3c3);   		 
   			 
   	 
   			 //=============End of button===================
   			 
   			 JButton btnMenuComp = new JButton("");
   			 btnMenuComp.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\mainMenu.jpg"));
   			 btnMenuComp.addActionListener(new ActionListener() {
   				 public void actionPerformed(ActionEvent e) {
   					 Menu.setVisible(true);
   					 play_comp.setVisible(false);
   				 }
   			 });
   			 btnMenuComp.setBounds(454, 338, 80, 80);
   			 play_comp.add(btnMenuComp);
   			 
   			 
   			 JButton restartComp = new JButton("");
   			 restartComp.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\restartBtn.png"));
   			 restartComp.addActionListener(new ActionListener(){
   				 public void actionPerformed(ActionEvent e){
   						    					 
   					 playerWin = false;
   					 compWin = false;
   					 
   					 compTurn = 1;
   					 
   					 //reset button text to ""
   					 compR1c1.setText("");
   					 compR2c1.setText("");
   					 compR3c1.setText("");
   					 
   					 compR1c2.setText("");
   					 compR2c2.setText("");
   					 compR3c2.setText("");
   					 
   					 compR1c3.setText("");
   					 compR2c3.setText("");
   					 compR3c3.setText("");
   					 
   					 
   					 //reset pressed buttons
   					 cpR1c1 = cpR2c1 = cpR3c1 = cpR1c2 = cpR2c2
   						 = cpR3c2 = cpR1c3 = cpR2c3 = cpR3c3 = 0;
   					 
   					 //reset the array of playerGridp and compGrid
   					 playerGrid[0] = playerGrid[1] = playerGrid[2] = playerGrid[3] =
   							playerGrid[4] = playerGrid[5] = playerGrid[6] = playerGrid[7] = playerGrid[8]= 0;
   					 
   					 compGrid[0] = compGrid[1] = compGrid[2] = compGrid[3] =
   							compGrid[4] = compGrid[5] = compGrid[6] = compGrid[7] = compGrid[8]= 0;
   					
   					 //hide winning message
   					 displayPlayer.setVisible(false);
   					 displayComp.setVisible(false);
   				 }
   				 
   			 });
   			 
   			 restartComp.setBounds(454,241,122,46);
   			 play_comp.add(restartComp);   			 
   			 
   			 JLabel lblNewLabel_4 = new JLabel("");
   			 lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\bgTic.jpg"));
   			 lblNewLabel_4.setBounds(0, 0, 645, 460);
   			 play_comp.add(lblNewLabel_4);
   			 

   			 
   	 //=========================HOW TO PLAY=============================
   	 
   	 final JPanel HowToPlay = new JPanel();
   	 HowToPlay.setBackground(new Color(192, 192, 192));
   	 frame.getContentPane().add(HowToPlay, "name_57690143149997");
   	 HowToPlay.setLayout(null);
   	 
   	 JButton btnMenuBut = new JButton("");
   	 btnMenuBut.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\mainMenu.jpg"));
   	 btnMenuBut.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e) {
   			 Menu.setVisible(true);
   			 HowToPlay.setVisible(false);    
   		 }
   	 });
   	 btnMenuBut.setBounds(514, 342, 80, 80);
   	 HowToPlay.add(btnMenuBut);
   	 
   	 explain = new JLabel();
   	 
   	 String explanation = "Tic Tac Toe is a 3 by 3 board game. "
   			 + "There are 2 players the first player will have an icon of X while the second player will have O. "
   			 + "Each players take alernate turn to place their icon. The first player to get 3 vertical, "
   			 + "horizontal or diagnolly icon wins the game.";
   	 
   	 //use <html> to get max width
   	 explain.setText("<html>" + explanation + "</html>");
   	 
   	 explain.setFont(new Font("Algerian", Font.PLAIN, 22));
   	 explain.setBounds(54, 85, 374, 310);
   	 HowToPlay.add(explain);
   	 
   	 title = new JLabel("How to play");
   	 title.setFont(new Font("Verdana", Font.BOLD, 28));
   	 title.setBounds(154, 30, 233, 59);
   	 HowToPlay.add(title);
   	 
   	 JLabel howPlayImg = new JLabel("");
   	 
   	 howPlayImg.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\explainImg.jpg"));
   	 
   	 howPlayImg.setBounds(434, 43, 200, 184);
   	 HowToPlay.add(howPlayImg);
   	 
   	 JLabel lblNewLabel_5 = new JLabel("");
   	 lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\bgTic.jpg"));
   	 lblNewLabel_5.setBounds(0, 0, 645, 460);
   	 HowToPlay.add(lblNewLabel_5);

   	 //==================End of how to play====================
   	 
   	 //=======================Level/difficulty==============================
   	 
   	 final JPanel Category = new JPanel();       
   	 Category.setBackground(Color.LIGHT_GRAY);
   	 frame.getContentPane().add(Category, "name_59014313242373");
   	 Category.setLayout(null);
   	 
   	 // buttons of category
   	 
   	 //**each time it click human, it must reset the screen**
   	 JButton btnHuman = new JButton("Vs Human");
   	 btnHuman.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e) {
   			 // link to play panel
   			 Play.setVisible(true);
   			 Category.setVisible(false);
   		 }
   	 });
   	 btnHuman.setBounds(109, 141, 186, 39);
   	 Category.add(btnHuman);
   	 
   	 JButton btnComputer = new JButton("Vs Computer");
   	 btnComputer.addActionListener(new ActionListener(){
   		 public void actionPerformed(ActionEvent e){
   			 // link to playVsComputer panel
   			 play_comp.setVisible(true);
   			 Category.setVisible(false);
   		 }
   	 });
   	 btnComputer.setBounds(337, 141, 211, 39);
   	 Category.add(btnComputer);
   	 
   	 JButton btnMenu = new JButton("");
   	 btnMenu.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\mainMenu.jpg"));
   	 btnMenu.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e) {
   			 Menu.setVisible(true);
   			 Category.setVisible(false);
   		 }
   	 });
   	 btnMenu.setBounds(277, 262, 80, 80);
   	 Category.add(btnMenu);
   	 
   	 //==================End of category buton==============
   	 
   	 JLabel lblPleaseChooseYour = new JLabel("Please choose your opponent!");
   	 lblPleaseChooseYour.setFont(new Font("Microsoft NeoGothic", Font.BOLD, 16));
   	 lblPleaseChooseYour.setHorizontalAlignment(SwingConstants.CENTER);
   	 lblPleaseChooseYour.setBounds(211, 42, 239, 44);
   	 Category.add(lblPleaseChooseYour);
   	 
   	 JLabel label = new JLabel("");
   	 label.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\bgTic.jpg"));
   	 label.setBounds(0, 0, 645, 460);
   	 Category.add(label);
   	 Category.setVisible(false);
   	 
   	 
   	 JButton btnNewButton = new JButton("");
   	 btnNewButton.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\playBtn.png"));
   	 btnNewButton.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e) {
   			 Category.setVisible(true);
   			 Menu.setVisible(false);
   		 }
   	 });
   	 btnNewButton.setBounds(222, 135, 178, 55);
   	 Menu.add(btnNewButton);
   	 
   	 JButton btnNewButton_1 = new JButton("");
   	 btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\infoBtn.png"));
   	 btnNewButton_1.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e) {
   			 HowToPlay.setVisible(true);
   			 Menu.setVisible(false);
   		 }
   	 });
   	 btnNewButton_1.setBounds(133, 236, 192, 55);
   	 Menu.add(btnNewButton_1);
   	 
   	 JButton btnNewButton_2 = new JButton("");
   	 btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\exitBtn.png"));
   	 btnNewButton_2.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e) {
   			 System.exit(0);
   		 }
   	 });
   	 btnNewButton_2.setBounds(400, 236, 115, 53);
   	 Menu.add(btnNewButton_2);
   	 
   	 JLabel lblMadeByVickel = new JLabel("Made By Vickel Leung");
   	 lblMadeByVickel.setForeground(Color.DARK_GRAY);
   	 lblMadeByVickel.setFont(new Font("Rage Italic", Font.BOLD, 26));
   	 lblMadeByVickel.setHorizontalAlignment(SwingConstants.RIGHT);
   	 lblMadeByVickel.setBounds(351, 407, 267, 53);
   	 Menu.add(lblMadeByVickel);
   	 
   	 JLabel lblNewLabel = new JLabel("Tic Tac Toe");
   	 lblNewLabel.setFont(new Font("Papyrus", Font.BOLD, 40));
   	 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
   	 lblNewLabel.setBounds(161, 39, 295, 60);
   	 Menu.add(lblNewLabel);
   	 
   	 JLabel lblNewLabel_2 = new JLabel("");
   	 lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vicke\\eclipse-workspace\\tictactoe\\img\\bgImg.jpg"));
   	 lblNewLabel_2.setBounds(-51, 0, 696, 465);
   	 Menu.add(lblNewLabel_2);
   	 
    }
}