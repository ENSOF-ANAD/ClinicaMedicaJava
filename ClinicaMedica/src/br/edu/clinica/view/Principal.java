package br.edu.clinica.view;

import br.edu.clinica.model.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Principal {

    private final DefaultListModel<Paciente> pacienteListModel = new DefaultListModel<>();
    private JList<Paciente> pacienteList;
    private JTextArea detalhesArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Principal().criarEExibirInterface());
    }

    private void criarEExibirInterface() {
        Paciente paciente1 = new Paciente();
        paciente1.nome = "Ana";
        paciente1.idade = 32;
        paciente1.cpf = "123.456.789-00";

        Paciente paciente2 = new Paciente();
        paciente2.nome = "Carlos";
        paciente2.idade = 45;
        paciente2.cpf = "987.654.321-00";

        Medico medico1 = new Medico();
        medico1.nome = "Dra. Mariana";
        medico1.crm = "CRM-12345";
        medico1.especialidade = "Cardiologia";

        Consulta consulta1 = new Consulta();
        consulta1.paciente = paciente1;
        consulta1.medico = medico1;
        consulta1.data = "10/10/2026";

        pacienteListModel.addElement(paciente1);
        pacienteListModel.addElement(paciente2);

        JFrame frame = new JFrame("Clínica Médica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        pacienteList = new JList<>(pacienteListModel);
        pacienteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pacienteList.setBorder(BorderFactory.createTitledBorder("Pacientes"));
        pacienteList.setFixedCellHeight(28);

        detalhesArea = new JTextArea();
        detalhesArea.setEditable(false);
        detalhesArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        detalhesArea.setMargin(new Insets(12, 12, 12, 12));
        detalhesArea.setBorder(BorderFactory.createTitledBorder("Detalhes"));

        pacienteList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }

                Paciente pacienteSelecionado = pacienteList.getSelectedValue();
                if (pacienteSelecionado == null) {
                    detalhesArea.setText("");
                    return;
                }

                StringBuilder texto = new StringBuilder();
                texto.append("=== PACIENTE ===\n");
                texto.append("Nome: ").append(valorOuVazio(pacienteSelecionado.nome)).append("\n");
                texto.append("Idade: ").append(pacienteSelecionado.idade).append("\n");
                texto.append("CPF: ").append(valorOuVazio(pacienteSelecionado.cpf)).append("\n\n");

                if (consulta1.paciente == pacienteSelecionado) {
                    texto.append("=== CONSULTA ===\n");
                    texto.append("Data: ").append(valorOuVazio(consulta1.data)).append("\n");
                    texto.append("Médico: ").append(valorOuVazio(consulta1.medico != null ? consulta1.medico.nome : null)).append("\n");
                    texto.append("Especialidade: ").append(valorOuVazio(consulta1.medico != null ? consulta1.medico.especialidade : null));
                } else {
                    texto.append("Nenhuma consulta cadastrada para este paciente.");
                }

                detalhesArea.setText(texto.toString());
            }
        });

        JButton adicionarPacienteButton = new JButton("Adicionar paciente");
        adicionarPacienteButton.addActionListener(e -> {
            Paciente novoPaciente = new Paciente();
            novoPaciente.nome = "Novo Paciente";
            novoPaciente.idade = 0;
            novoPaciente.cpf = "";
            pacienteListModel.addElement(novoPaciente);
            pacienteList.setSelectedValue(novoPaciente, true);
        });

        JSplitPane painelDivisor = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(pacienteList),
                new JScrollPane(detalhesArea)
        );
        painelDivisor.setDividerLocation(220);
        painelDivisor.setResizeWeight(0.3);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelInferior.add(adicionarPacienteButton);

        frame.add(painelDivisor, BorderLayout.CENTER);
        frame.add(painelInferior, BorderLayout.SOUTH);

        frame.setSize(760, 430);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        if (!pacienteListModel.isEmpty()) {
            pacienteList.setSelectedIndex(0);
        }
    }

    private String valorOuVazio(String valor) {
        return valor == null ? "" : valor;
    }
}
