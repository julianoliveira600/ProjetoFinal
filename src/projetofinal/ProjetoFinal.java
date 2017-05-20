
package projetofinal;


public class ProjetoFinal {


    public static void main(String[] args){
        /**
         * Teste Cliente
         * 
        */
        TestCliente testCliente = new TestCliente();
        int id = testCliente.testInsert();
        testCliente.testUpdate(id);
        System.out.println("Listar");
        testCliente.testList();
        System.out.println("Visualizar");
        testCliente.testView(id);
        //TestFuncionario testFuncionario = new TestFuncionario();
        //testFuncionario.testInsert();
    }  
}
