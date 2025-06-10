package controller;

//imports necessários para a criação de documentos pdf usando iText - iText é uma biblioteca java que permite a criação e manipulação de dados em arquivos pdf
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;

//imports para criação de arquivos word com apache poi - apache poi eh uma biblioteca java que permite manipular dados em arquivos padrão do office (como excel e word)
import org.apache.poi.xwpf.usermodel.*;

//imports para manipulação de planilhas excel com apache poi
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//imports de bibliotecas java/swing
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

/** Classe EmitirRelatorio é uma classe feita para emitir relatórios arquivos em pdf/word/excel
 *
 * @author laispaivaportela
 */
public class EmiteRelatorio {

    //exporta a table pra um arquivo (pdf, xlsx ou docx)

    /**
     * metodo que exporta o arquivo
     * @param table valor inicial para o table
     */
    public void exportaArquivo(JTable table) {
        //file chooser (seletor de ficheiros) - elemento que permite escolher um ficheiro 
        JFileChooser chooser = new JFileChooser(); //cria um seletor de arquivos
        chooser.setDialogTitle("Salvar Arquivo"); //define o titulo como salvar arquivo

        //cria filtros para os tipos de arquivo disponíveis
        FileNameExtensionFilter excel = new FileNameExtensionFilter("Arquivo Excel (*.xlsx)", "xlsx"); //para criar a extensao de arquivo excel (padrão q é xlsx)
        FileNameExtensionFilter pdf = new FileNameExtensionFilter("Documento PDF (*.pdf)", "pdf"); //para criar a extensao de arquivo pdf 
        FileNameExtensionFilter docx = new FileNameExtensionFilter("Documento Word (*.docx)", "docx"); //para criar a extensão de arquivo word (padrão q é docx)

        //adiciona os filtros no seletor
        chooser.addChoosableFileFilter(excel); 
        chooser.addChoosableFileFilter(pdf);
        chooser.addChoosableFileFilter(docx);

        chooser.setFileFilter(excel); //define excel como padrão (porque é a saída mais comum)

        //mostra a janela de salvar e verifica se o usuário confirmou
        int escolha = chooser.showSaveDialog(null);
        if (escolha == JFileChooser.APPROVE_OPTION) {
            File arquivo = chooser.getSelectedFile(); //obtem o arquivo escolhido
            String extensao = ((FileNameExtensionFilter) chooser.getFileFilter()).getExtensions()[0];

            //garante que a extensao sera adicionada ao final do nome do arquivo
            if (!arquivo.getName().toLowerCase().endsWith("." + extensao)) {
                arquivo = new File(arquivo.getAbsolutePath() + "." + extensao);
            }

            //chama o método de exportacao correspondente à extensão escolhida (e manda a table)
            if (extensao.equals("xlsx")) {
                exportaTabelaParaExcel(table, arquivo);
            } else if (extensao.equals("pdf")) {
                exportarParaPDF(arquivo, table);
            } else if (extensao.equals("docx")) {
                exportarParaWord(table, arquivo);
            }
        }
    }

    //exporta os dados da table para uma planilha excel (.xlsx)

    /**
     * metodo que exporta tabela para o excel
     * @param table valor inicial para o table
     * @param arquivo valor inicial para o arquivo
     */
    public void exportaTabelaParaExcel(JTable table, File arquivo) {
        try (Workbook workbook = new XSSFWorkbook()) { //cria uma nova planilha do tipo .xlsx
            Sheet sheet = workbook.createSheet("Produtos"); //cria a aba chamada "Produtos"
            TableModel modelo = table.getModel(); //obtem o modelo de dados da table

            //cria a linha de cabeçalho com os nomes das colunas
            Row cabecalho = sheet.createRow(0);
            for (int col = 0; col < modelo.getColumnCount(); col++) {
                Cell cell = cabecalho.createCell(col);
                cell.setCellValue(modelo.getColumnName(col)); //define o nome da coluna
            }

            //preenche as linhas da planilha com os dados da table
            for (int row = 0; row < modelo.getRowCount(); row++) {
                Row linha = sheet.createRow(row + 1); //comeca da linha 1 (porque a llinha 0 é o cabeçalho)
                for (int col = 0; col < modelo.getColumnCount(); col++) {
                    Object valor = modelo.getValueAt(row, col);
                    Cell cell = linha.createCell(col);

                    if (valor instanceof Number) {
                        cell.setCellValue(((Number) valor).doubleValue()); //insere como número
                    } else {
                        cell.setCellValue(valor != null ? valor.toString() : ""); //insere como texto
                    }
                }
            }

            //ajusta automaticamente a largura das colunas
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                sheet.autoSizeColumn(i);
            }

            //grava os dados no arquivo .xlsx
            try (FileOutputStream fos = new FileOutputStream(arquivo)) {
                workbook.write(fos);
            }

            //mensagem de sucesso (caso tenha sucesso)
            JOptionPane.showMessageDialog(null, "Exportado com sucesso para:\n" + arquivo.getAbsolutePath());

        } catch (IOException ex) {
            //mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao exportar: " + ex.getMessage());
        }
    }

    //exporta os dados da table para um arquivo pdf usando a biblioteca iText

    /**
     * metodo que exporta tabela para o pdf
     * @param arquivo valor inicial para o arquivo
     * @param table valor inicial para o table
     */
    public void exportarParaPDF(File arquivo, JTable table) {
        try {
            Document document = new Document(); //cria um documento pdf
            PdfWriter.getInstance(document, new FileOutputStream(arquivo)); //associa a saída ao arquivo
            document.open(); //abre o documento para escrita

            //define fontes para cabeçalho e células
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font fonteCabecalho = new Font(bf, 12, Font.BOLD);
            Font fonteCelula = new Font(bf, 12);

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount()); //cria uma tabela com o número de colunas da JTable
            pdfTable.setWidthPercentage(100); //define a largura como 100%

            //adiciona os cabeçalhos das colunas
            for (int i = 0; i < table.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(table.getColumnName(i), fonteCabecalho));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER); //vai centralizar o texto
                pdfTable.addCell(cell);
            }

            //adiciona os dados da tabela
            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    Object valor = table.getValueAt(rows, cols);
                    PdfPCell cell = new PdfPCell(new Phrase(valor != null ? valor.toString() : "", fonteCelula));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }
            }

            document.add(pdfTable); //adiciona a tabela ao documento
            document.close(); //fecha o documento

            //mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Exportado com sucesso para:\n" + arquivo.getAbsolutePath());

        } catch (Exception e) {
            //mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao exportar para PDF: " + e.getMessage());
        }
    }

    //exporta os dados da table para um documento word (.docx) usando "apache poi"

    /**     
     * metodo que exporta tabela para o word
     * @param table valor inicial para o table
     * @param arquivo valor inicial para o arquivo
     */
    public void exportarParaWord(JTable table, File arquivo) {
        try (XWPFDocument document = new XWPFDocument()) { //cria um novo documento Word
            XWPFTable wordTable = document.createTable(); //cria uma tabela no documento
            TableModel modelo = table.getModel(); //obtém o modelo de dados da table

            XWPFTableRow headerRow = wordTable.getRow(0); //a primeira linha (cabeçalho)
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                if (i == 0) {
                    headerRow.getCell(0).setText(modelo.getColumnName(0));
                } else {
                    headerRow.addNewTableCell().setText(modelo.getColumnName(i));
                }
            }

            //adiciona as linhas de dados
            for (int row = 0; row < modelo.getRowCount(); row++) {
                XWPFTableRow tableRow = wordTable.createRow();
                for (int col = 0; col < modelo.getColumnCount(); col++) {
                    Object valor = modelo.getValueAt(row, col);
                    tableRow.getCell(col).setText(valor != null ? valor.toString() : "");
                }
            }

            //grava o documento no arquivo .docx
            try (FileOutputStream out = new FileOutputStream(arquivo)) {
                document.write(out);
            }

            //mensagem de sucesso (caso tenha)
            JOptionPane.showMessageDialog(null, "Exportado com sucesso para:\n" + arquivo.getAbsolutePath());

        } catch (Exception e) {
            //mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao exportar para Word: " + e.getMessage());
        }
    }
}
