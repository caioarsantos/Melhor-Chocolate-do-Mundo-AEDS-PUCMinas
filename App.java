import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Random;

public class App {

//------------------------------------------------------------------------------------------------    
//Variaveis
//------------------------------------------------------------------------------------------------
static int maximoEleitores = 100;
static int minimoElitores = 0;

static public Eleitor[] eleitor = new Eleitor[maximoEleitores];
static public Eleitor[] eleitordois = new Eleitor[maximoEleitores];
static File file = new File("eleitores.txt");
static public Scanner scan = new Scanner(System.in);

//------------------------------------------------------------------------------------------------
//Mostra a informacao
//------------------------------------------------------------------------------------------------
public static void ShowInfo(Eleitor eleitor){

int titulo = eleitor.getTitulo();
String nome = eleitor.getNome();
int zona = eleitor.getZona();
int secao = eleitor.getSecao();

System.out.println("             Dados              ");
System.out.println("--------------------------------");
System.out.println("Titulo Eleitoral: "+ titulo);
System.out.println("Nome:             "+ nome);
System.out.println("Zona Eleitoral:   "+ zona);
System.out.println("Seção:            "+ secao);
System.out.println("--------------------------------");
}

//------------------------------------------------------------------------------------------------
//Ler dados do arquivo
//------------------------------------------------------------------------------------------------
public static void lerDados(){
int x = 0; 
Eleitor eleitortreis = null;
    try{
    FileReader fr = new FileReader(file);
    BufferedReader r = new BufferedReader(fr);
    String dadosstring;   
        while((dadosstring = r.readLine()) != null){
          String [] dados = dadosstring.split(";");
          eleitortreis = new Eleitor();
          eleitortreis.setTitulo(Integer.parseInt(dados[0])); 
          eleitortreis.setNome(dados[1]);
          eleitortreis.setZona(Integer.parseInt(dados[2]));
          eleitortreis.setSecao(Integer.parseInt(dados[3]));
          eleitordois[x] = eleitortreis;
          x = x+1;
        }
    r.close();
    }
    catch(Exception e){
      return;
    }
}

//------------------------------------------------------------------------------------------------
//Escrever dadaos
//------------------------------------------------------------------------------------------------
public static void escreverDados(int titulo, String nome, int zona, int secao){
   
try{
    FileWriter fw = new FileWriter(file,true);
    BufferedWriter w = new BufferedWriter(fw);
    w.write(titulo + ";" + nome + ";" + zona + ";" + secao + "\n");
    w.close();
}
catch(Exception e){
    return;
}
}

//------------------------------------------------------------------------------------------------
//Menu
//------------------------------------------------------------------------------------------------
public static int menu(){
int menu = 0;

System.out.println("            MELHOR CHOCOLATE DO MUNDO             ");
System.out.println("--------------------------------------------------");
System.out.println("1- Adicionar novo eleitor");
System.out.println("2- Ver eleitores");
System.out.println("3- Sair");
System.out.println("5- Gerar os valores aleatórios");
System.out.println("--------------------------------------------------");

menu = scan.nextInt();

return menu;
}

//------------------------------------------------------------------------------------------------
//Menu
//------------------------------------------------------------------------------------------------
static public void novoEleitor(){
Scanner scan = new Scanner(System.in);
int id;
String nome;
int zona;
int secao;
System.out.println("ID----------------------------------------------------");
id = scan.nextInt();
System.out.println("NOME--------------------------------------------------");
nome = scan.next();
System.out.println("ZONA--------------------------------------------------");
zona = scan.nextInt();
System.out.println("SECAO-------------------------------------------------");
secao = scan.nextInt();

escreverDados(id, nome, zona, secao);

scan.close();
}

//------------------------------------------------------------------------------------------------
//Ordenar eleitores por secao
//------------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------
//Quicksort
//------------------------------------------------------------------------------------------------


//------------------------------------------------------------------------------------------------
//Random
//------------------------------------------------------------------------------------------------
static public void randomGenerator(){

int id = (int)Math.floor(Math.random() * 100);
int zona = (int)Math.floor(Math.random() * 100);
int secao = (int)Math.floor(Math.random() * 6);
int leftLimit = 97; // letter 'a'
int rightLimit = 122; // letter 'z'
int targetStringLength = 10;
Random random = new Random();

String nome = random.ints(leftLimit, rightLimit + 1)
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();

escreverDados(id, nome, zona, secao);

}

//------------------------------------------------------------------------------------------------
//Main
//------------------------------------------------------------------------------------------------
public static void main(String[] args) throws Exception {
  
Boolean quit = false;
int menu;
lerDados();

while(!quit){
  menu = menu();
switch(menu){
  case 1:
  break;
  case 2: lerDados();
          for(int x = 0; x <100; x++ ){
            ShowInfo(eleitordois[x]);
          } 
  break;
  case 3: quit = true;
          scan.close();
  break;
  case 4: 
  break; 
  case 5: for(int x = 0; x <100; x++ ){
            randomGenerator();
          }
  break;
}
}
}
}


