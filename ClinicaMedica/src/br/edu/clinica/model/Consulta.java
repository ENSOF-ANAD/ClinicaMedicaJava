package br.edu.clinica.model;
public class Consulta {
 public Paciente paciente; public Medico medico; public String data;
 public void exibirResumo(){System.out.println("Consulta");System.out.println("Paciente: "+paciente.nome);System.out.println("Médico: "+medico.nome);System.out.println("Data: "+data);}
}
