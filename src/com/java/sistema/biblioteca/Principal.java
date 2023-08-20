package com.java.sistema.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	static Scanner leia = new Scanner(System.in);
	static ArrayList<Pessoa> contasUsers;
	static ArrayList<Livros> livro;
	static ArrayList<Conta> conta;
	
	public static void main(String[] args) {
      contasUsers = new ArrayList<Pessoa>();
      livro = new ArrayList<Livros>();
      conta = new ArrayList<Conta>();
      menu(); 
	}
	
	public static void menu() {
	
try {		
		 System.out.println("------------------------------------------------------");
         System.out.println("------------------SISTEMA BIBLIOTECA------------------");
         System.out.println("------------------------------------------------------");
         System.out.println("***** Selecione uma operação que deseja realizar *****");
         System.out.println("------------------------------------------------------");
         System.out.println("|   Opção 1 - Cadastrar Usúario        |");
         System.out.println("|   Opção 2 - Registrar Livro          |");
         System.out.println("|   Opção 3 - Listar Livros            |");
         System.out.println("|   Opção 4 - Achar Livro Individual   |");
         System.out.println("|   Opção 5 - Listar Clientes          |");
         System.out.println("|   Opção 6 - Alugar Livro             |");
         System.out.println("|   Opção 7 - Listar aluguel           |");
         System.out.println("|   Opção 8 - Retirar aluguel          |");
         System.out.println("|   Opção 9 - Listar Livro por nome    |");
         System.out.println("|   Opção 10 - Listar Cliente por nome |");
         System.out.println("|   Opção 11 - Sair                    |");
         
         int opt = leia.nextInt();
         
         switch (opt) {
         case 1:
        	 cadastrarUser();
        	 break;
         case 2:
        	 registrar();
        	 break;
         case 3:
        	 listarLivro();
        	 break;
         case 4:
        	 acharLivro();
        	 break;
         case 5:
        	 listarUser();
        	 break;
         case 6:
        	 alugar();
        	 break;
         case 7:
        	 listarAlugar();
        	 break;
         case 8:
        	 retirarAlugar();
        	 break;
         case 9:
        	 listarLivroInd();
        	 break;
         case 10:
        	 listarNomeInd();
        	 break;
         case 11:
        	 System.out.println("Encerrando o Programa.");
        	 System.exit(0);
        	 break;
        	 default:
        		 System.out.println("Escolha uma opção válida!");
        		 menu();
        		 break;
         } 
         }  catch (Exception e) {
        	   System.out.println("Escolha uma opção válida!");         
		}

}
		
		private static void listarNomeInd() {
			 boolean pessoaEncontrado = false;
	           if(livro.size() > 0) {
	        	   System.out.println("Digite o nome do livro:");
	        	   String pess = leia.next();
	                  for(Pessoa p : contasUsers) {
	                	  if(p.getNome().equalsIgnoreCase(pess)) {
	                		  pessoaEncontrado = true;
	                		  System.out.println(p);
	                		  break;}
	                  }
	           } else {
	        	   System.out.println("Não há Pessoas registrados para consulta");
	           }
	           if(pessoaEncontrado == true) {
	 		  System.out.println("Existe esse cliente na biblioteca");
	           } else {
	        	   System.out.println("Não existe esse cliente na biblioteca");
	           }

	           menu();
	}

		private static void listarLivroInd() {
    	    boolean livroEncontrado = false;
           if(livro.size() > 0) {
        	   System.out.println("Digite o nome do livro:");
        	   String liv = leia.next();
                  for(Livros l : livro) {
                	  if(l.getNome().equalsIgnoreCase(liv)) {
                		  livroEncontrado = true;
                		  System.out.println(l);
                		  break;}
                  }
           } else {
        	   System.out.println("Não há livros registrados para consulta");
           }
           if(livroEncontrado == true) {
 		  System.out.println("Existe esse livro na biblioteca");
           } else {
        	   System.out.println("Não existe esse livro na biblioteca");
           }

           menu();
	}

		private static void acharLivro() {
          if(livro.size() > 0) {
        System.out.println("Digite o Número de indentificação do livro: ");
        int num = leia.nextInt();
         
        Livros li = procurarLivro(num);
        
        if(li != null) {
        	System.out.println(li);
        } else {
        	System.out.println("Número do livro inválido!");
        }
          } else {
        	  System.out.println("Não tem nenhum livro Registrado para ser consultado!");
          }
          menu();
	}

		private static void listarAlugar() {
			 if(conta.size() > 0) {
	        	   for(Conta c : conta) {
	        		   System.out.println(c);
	        	   }
	           } else {
	        	   System.out.println("Não há registro de Aluguel");
	           }
	           menu();
	}

		private static void retirarAlugar() {
		    if (conta.size() > 0) {
		        System.out.println("Digite o número do livro a ser devolvido: ");
		        int numLivro = leia.nextInt();

		        Conta contaRemover = null;
		           for (Conta c : conta) {
		               if (c.getLivros().getNumLivro() == numLivro) {
		                   contaRemover = c;
		                break;
		            }
		        }

		        if (contaRemover != null) {
		            conta.remove(contaRemover);
		            System.out.println("Livro devolvido com sucesso!");
		           } else {
		                System.out.println("Livro não encontrado na lista de aluguel.");
		        }
		    } else {
		        System.out.println("Não há registro de aluguel.");
		    }
		    menu();
		}


		protected static Livros procurarLivro(int numL) {
		    if(livro.size() > 0) {
		        for(Livros l : livro) {
		            if(l.getNumLivro() == numL) {
		                return l;
		            }
		        }
		    }
		    return null;
		}


		public static void alugar() {
		    if (contasUsers.size() > 0 && livro.size() > 0) {
		        System.out.println("Digite o ID da conta para aluguel: ");
		        int id = leia.nextInt();
         
		        Pessoa pessoa = encontrarUser(id);

		        if (pessoa != null) {
		            System.out.println("Qual o Número do Livro para alugar: ");
		            int num = leia.nextInt();

		            if (!livroJaAlugado(num)) {
		                Livros l = procurarLivro(num);

		                if (l != null) {
		                    Conta alugar = new Conta(pessoa, l);
		                    conta.add(alugar);

		                    System.out.println("Livro alugado com sucesso!");
		                } else {
		                    System.out.println("Erro, Livro não encontrado!");
		                }
		            } else {
		                System.out.println("Erro, o livro já está alugado!");
		            }
		        } else {
		            System.out.println("Erro, Pessoa não encontrada!");
		        }
		    } else {
		        System.out.println("Erro, tente Novamente!");
		    }
		    
		    menu();
		}

		public static boolean livroJaAlugado(int numeroLivro) {
		    for (Conta aluguel : conta) {
		        if (aluguel.getLivros().getNumLivro() == numeroLivro) {
		            return true;
		        }
		    }
		    return false;
		}

		public static void listarUser() {
           if(contasUsers.size() > 0) {
        	   for(Pessoa p : contasUsers) {
        		   System.out.println(p);
        	   }
           } else {
        	   System.out.println("Não há registro de Clientes");
           }
           menu();
	}

		public static void listarLivro() {
			if(livro.size() > 0) {
				for(Livros l : livro) {
					System.out.println(l);
				} 
			} else {
				System.out.println("Não há livros registrados");
			}	
			menu();
	}

		public static void registrar() {
           System.out.println("Você está registrando um Livro.\n");
           
           System.out.println("Número de indentificação do Livro: ");
           int num = leia.nextInt();
           
           System.out.println("Nome do Livro: ");
           String nome = leia.next();
           
           
           System.out.println("Autor do Livro: ");
           String autor = leia.next();
          

           System.out.println("Editora de publicação: ");
           String editora = leia.next();
           
           System.out.println("###########LOCALIZAÇÃO##############\n");
           
           System.out.println("Número do Corredor: ");
           int corredor = leia.nextInt();
           
           System.out.println("Número da Pratileira: ");
           int pratileira = leia.nextInt();
           
           Pratileiras localizacao = new Pratileiras(corredor, pratileira);
           
           Livros livros = new Livros(num, nome, autor, editora, localizacao);
           
           livro.add(livros);
           
           System.out.println("Livro cadastrado com Sucesso!");
           
           menu();
	}

		public static void cadastrarUser() {
 try {
			System.out.println("Você está registrando um usúario. ");
			
			System.out.println("Nome: ");
			String nome = leia.next();
			
			System.out.println("Idade: ");
			int idade = leia.nextInt();

			String n = Integer.toString(idade);
			
			System.out.println("Sexo: (Use M, F ou N)");
			String sexo = leia.next();
			
			System.out.println("ID: (Use o cpf do cliente para seu id)");
			int id = leia.nextInt();
			
			Pessoa cliente = new Pessoa(nome,sexo,id,idade);
			
			cliente.setSexo(n);
			contasUsers.add(cliente);
			
			System.out.println("Sua conta foi criada!");
			menu();
 } catch(Exception e) {
	 System.out.println("Erro no cadastramento, tente novamente!\n");
	 menu();
 }
			
	}
		protected static Pessoa encontrarUser(int numUser) {
		    for (Pessoa p : contasUsers) {
		        if (p.getId() == numUser) {
		            return p;
		        }
		    }
		    return null;
		}

}
	


