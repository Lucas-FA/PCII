package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.CriaturasJdbcDAO;
import controller.DeusesJdbcDAO;
import controller.JdbUtil;
import model.Criaturas;
import model.Deuses;

public class App extends JFrame{
    JTextField txtNome = new JTextField();
    JLabel lblNome = new JLabel("Nome: ");
    	
    JTextField txtOrigem = new JTextField();
    JLabel lblOrigem = new JLabel("Origem: ");
    	
    JTextField txtMoradia = new JTextField();
    JLabel lblMoradia = new JLabel("Moradia: ");

    JButton btnSalvar = new JButton("Salvar");

    public App() {
    	super("Cadastro");
    		
    	Container paine = this.getContentPane();
    		
    	paine.add(lblNome);
    	lblNome.setBounds(10, 15, 45, 30);
    	paine.add(txtNome);	
    	txtNome.setBounds(90, 15, 225, 30);
    		
    	paine.add(lblOrigem);
    	lblOrigem.setBounds(10, 50, 70, 30);
    	paine.add(txtOrigem);	
    	txtOrigem.setBounds(90, 50, 225, 30);	
    		
    	paine.add(lblMoradia);
    	lblMoradia.setBounds(10, 85, 70, 30);
    	paine.add(txtMoradia);	
    	txtMoradia.setBounds(90, 85, 225, 30);
   		
   		paine.add(btnSalvar);
   		btnSalvar.setBounds(250, 250, 130, 30);
   		btnSalvar.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			try {
    			Criaturas c = new Criaturas();
    			c.setNome(txtNome.getText());
   				c.setOrigem(txtOrigem.getText());
   				c.setMoradia(txtMoradia.getText());
    				
   				Connection connection = JdbUtil.getConnection();
   				CriaturasJdbcDAO criaturasJdbcDao = new CriaturasJdbcDAO(connection);
    				
   				criaturasJdbcDao.salvar(c);
    				
    			}catch(Exception ex) {
    				ex.printStackTrace();
   				}
   				
   			}
   		});
    		
    	this.setLayout(null);
    	this.setVisible(true);
   		this.setSize(600, 330);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   	public static void main(String[] args){
       	App app = new App();
    }
}
