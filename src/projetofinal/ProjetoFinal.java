
package projetofinal;


public class ProjetoFinal {


    public static void main(String[] args){
      
        TestCliente testCliente = new TestCliente();
//        int id = testCliente.testInsert();
//        testCliente.testUpdate(3);
        System.out.println("Listar");
        testCliente.testList();
        System.out.println("Visualizar");
        testCliente.testView(2);
            //testCliente.testInsert();
           /**
         * Teste Cliente
         * 
        */ 
        System.out.println("Começa funcionario");
        TestFuncionario testFuncionario = new TestFuncionario();
//        testFuncionario.testInsert();
//        testFuncionario.testView(1);
////            testFuncionario.testUpdate(10);
//                testFuncionario.testList();
          
        
        
    }  
}
