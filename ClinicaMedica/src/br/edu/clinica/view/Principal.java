package br.edu.clinica.view;
import br.edu.clinica.model.*;
public class Principal {
 public static void main(String[] args){
  Paciente paciente1=new Paciente(); paciente1.nome="Ana"; paciente1.idade=32; paciente1.cpf="123.456.789-00";
  Paciente paciente2=new Paciente(); paciente2.nome="Carlos"; paciente2.idade=45; paciente2.cpf="987.654.321-00";
  System.out.println("=== PACIENTES ==="); paciente1.exibirDados(); System.out.println(); paciente2.exibirDados();
  Medico medico1=new Medico(); medico1.nome="Dra. Mariana"; medico1.crm="CRM-12345"; medico1.especialidade="Cardiologia";
  System.out.println("\n=== MÉDICO ==="); medico1.exibirDados();
  Consulta consulta1=new Consulta(); consulta1.paciente=paciente1; consulta1.medico=medico1; consulta1.data="10/10/2026";
  System.out.println("\n=== CONSULTA ==="); consulta1.exibirResumo();
 }
}
