package main;

import DAO.ContatoDAO;
import agenda.Contato;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author rodri
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        ContatoDAO contatoDAO = new ContatoDAO();
        Contato contato = new Contato();
        Scanner ler = new Scanner(System.in);
        String opcao = new String();
        
        //----------------------------------------------------------------- INICIO MENU PRINCIPAL ------------------------------------------------------------- //

        do {
            System.out.println(" ~~~~~~~  BEM VINDO(A) A SUA AGENDA PESSOAL ~~~~~~~");
            System.out.println("\n");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Exibir lista completa");
            System.out.println("2 - Adicionar contato");
            System.out.println("3 - Atualizar contato");
            System.out.println("4 - Deletar contato");
            System.out.println("5 - Sair da aplicacao");
            
            System.out.print("\nDigite o numero referente a opcao que deseja: ");
            opcao = ler.nextLine();
            System.out.println("\n\n\n");
            
            // ------ tratando escolha do menu
            
            switch(opcao){
                case "1" -> {
                    // VISUALIANDO REGISTROS -- READ
                    
                    int tamanho = contatoDAO.getContatos().size();
                    System.out.println("\nVoce tem: "+ tamanho + " contatos cadastrados.\n\n");
                    
                    for(Contato c : contatoDAO.getContatos()){
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.println("ID = " + c.getId_ctt() + "\nNOME = " + c.getNome_ctt() + " | TELEFONE = " + c.getTelefone_ctt() + " | EMAIL = " + c.getEmail_ctt());
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.println("\n\n\n");
                    System.out.println("0 - Voltar ao menu principal");
                    System.out.println("5 - Sair do aplicativo");
                    System.out.println("\nO que deseja fazer?");
                    opcao = ler.nextLine();
                    System.out.println("\n\n\n");
                }
                case "2" -> {
                    // INSERINDO DADO -- CREATE
                    String dnv = "2";
                    while(dnv.equals("2")){
                        String nomectt = new String();
                        String telefonectt = new String();
                        String emailctt = new String();
                        
                        
                        System.out.print("Qual o nome do contato que deseja inserir? ");
                        nomectt = ler.nextLine();
                        System.out.print("Qual o telefone do(a) " + nomectt + "? ");
                        telefonectt = ler.nextLine();
                        System.out.print("Qual o email do(a) " + nomectt + "? ");
                        emailctt = ler.nextLine();
                        contato.setNome_ctt(nomectt);
                        contato.setTelefone_ctt(telefonectt);
                        contato.setEmail_ctt(emailctt);

                        System.out.println("\n\n\nVerificando dados...\n");
                        Thread.sleep(1000);
                        System.out.println("Inserindo no banco de dados...\n");
                        Thread.sleep(1000);
                        contatoDAO.save(contato);
                        System.out.println("--> " + nomectt + " | " + telefonectt + " | " + emailctt + "<-- foi inserido com sucesso!\n\n");
                        Thread.sleep(1000);


                        System.out.println("0 - Voltar ao menu principal");
                        System.out.println("2 - Inserir outro contato");
                        System.out.println("5 - Sair do aplicativo");
                        System.out.print("\nO que deseja fazer? ");
                        dnv = ler.nextLine();
                        System.out.println("\n\n\n");
                        opcao = dnv;
                    }
                }
                case "3" -> {
                    // EDITANDO CONTATO -- UPDATE
                    String dnv = "2";
                    while(dnv.equals("2")){
                    Contato c1 = new Contato();
                    int idctt;
                    String nomectt = new String();
                    String telefonectt = new String();
                    String emailctt = new String();
                    
                                //exibindo todos contatos para ver o ind
                    for(Contato c : contatoDAO.getContatos()){
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.println("ID = " + c.getId_ctt() + " | " + c.getNome_ctt() + " | " + c.getTelefone_ctt() + " | " + c.getEmail_ctt());
                    }
                    
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.println("\n");
                    System.out.print("Qual o id do contato que voce deseja atualizar? ");
                    idctt = ler.nextInt();
                    System.out.print("Qual o novo nome do contato? ");
                    nomectt = ler.nextLine();
                    System.out.print("Qual o  novo telefone do(a) " + nomectt + "? ");
                    telefonectt = ler.nextLine();
                    System.out.print("Qual o novo email do(a) " + nomectt + "? ");
                    emailctt = ler.nextLine();
                    
                    c1.setId_ctt(idctt);
                    c1.setNome_ctt(nomectt);
                    c1.setTelefone_ctt(telefonectt);
                    c1.setEmail_ctt(emailctt);
                    
                    System.out.println("\n\n\nVerificando dados...\n");
                    Thread.sleep(1000);
                    System.out.println("Inserindo atualização no banco de dados...\n");
                    Thread.sleep(1000);
                    contatoDAO.update(c1);
                    System.out.println("--> " + nomectt + " | " + telefonectt + " | " + emailctt + "<-- foi atualizado com sucesso!\n\n");
                    Thread.sleep(1000);
                            
                    System.out.println("0 - Voltar ao menu principal");
                    System.out.println("2 - Inserir outro contato");
                    System.out.println("5 - Sair do aplicativo");
                    System.out.print("\nO que deseja fazer? ");
                    dnv = ler.nextLine();
                    System.out.println("\n\n\n");
                    opcao = dnv;
                    }
                    
                }
                case "4" -> {
                    String dnv = "2";
                    int idctt;
                    while(dnv.equals("2")){
                        
                    //exibindo todos contatos para ver o ind
                    for(Contato c : contatoDAO.getContatos()){
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.println("ID = " + c.getId_ctt() + " | " + c.getNome_ctt() + " | " + c.getTelefone_ctt() + " | " + c.getEmail_ctt());
                    }
                    
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.println("\n");
                    System.out.print("Qual o id do contato que voce deseja atualizar? ");
                    idctt = ler.nextInt();
                    System.out.println("\n\n\nVerificando dados...\n");
                    Thread.sleep(1000);
                    System.out.println("Inserindo atualização no banco de dados...\n");
                    Thread.sleep(1000);
                    contatoDAO.delete(idctt);
                    System.out.println("O contato com -->  ID  " + idctt + " <-- foi deletado com sucesso!\n\n");
                    Thread.sleep(1000);
                    
                    System.out.println("0 - Voltar ao menu principal");
                    System.out.println("2 - Deletar outro contato");
                    System.out.println("5 - Sair do aplicativo");
                    System.out.print("\nO que deseja fazer? ");
                    dnv = ler.nextLine();
                    System.out.println("\n\n\n");
                    opcao = dnv;
                    }
                }
                case "5" -> {

                }
                case "0" -> {
                      System.out.println("~~~~~~~~ Voltando ao menu principal ~~~~~~~~");
                      Thread.sleep(1000);
                      System.out.println("\n\n\n\n");
                }
                default -> {
                    System.out.println("Opcao invalida!\n\n");
                    Thread.sleep(1000);
                    System.out.println("Digite um número presente no menu\n\n\n");
                    Thread.sleep(1000);
                    opcao = "1";
                }
            }
            
        }while(!opcao.equals("5"));
        
        // ---------------------------------------------------------------- FIM MENU PRINCIPAL ----------------------------------------------------------------- //
        
            System.out.println("Obrigado por usar sua agenda pessoal!");
            Thread.sleep(1000);
            System.out.println("Saindo...");
            Thread.sleep(1000);
    }
    
}
