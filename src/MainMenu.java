
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
        searchWord.setEnabled(false);
        WordCounterButton.setEnabled(false);
        WordSearchButton.setEnabled(false);
        AuthenticityButton.setEnabled(false);
        FrequentWords.setEnabled(false);
        String names[] = new String[2];
    }
    
    public void countWordsMenu(){
        jPanel3.setVisible(false);
    }
    
    public void addDoc1(String[] names){
        chooser.showOpenDialog(null);
        File doc = chooser.getSelectedFile();
        String doc1Name = doc.getName();

        
        String doc1Path = "test\\doc1.txt";
        
        if(doc.isFile()){
            names[0] = doc1Name + " - doc1";
            String fileName = doc.getAbsolutePath();
            try {
                Scanner sc1 = new Scanner(doc);
                String string = "";
                while (sc1.hasNextLine()){
                    string = string.concat(sc1.nextLine() + "\n"); 
                }
                
                try {
                    FileWriter w1 = new FileWriter(doc1Path);
                    w1.write(string);
                    w1.close();
                    WordCounterButton.setEnabled(true);
                    WordSearchButton.setEnabled(true);
                    FrequentWords.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Se ha cargado correctamente el documento.");
                } catch (IOException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar cargar el archivo, por favor intente de nuevo.");
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar crear el archivo, por favor intente de nuevo.");
            }

        }else{
            JOptionPane.showMessageDialog(null, "El archivo seleccionado debe ser .txt.\nPor favor seleccione un archivo de extensión .txt.");
        }
    }
    
    public void addDoc2(String[] names){
            String doc2Path = "test\\doc2.txt";

        chooser.showOpenDialog(null);
        File doc2 = chooser.getSelectedFile();
        String doc2Name = doc2.getName();

        if (doc2.isFile()) {
            names[1] = doc2Name + " - doc2";
            String fileName = doc2.getAbsolutePath();
            try {
                Scanner sc2 = new Scanner(doc2);
                String string = "";
                while (sc2.hasNextLine()) {
                    string = string.concat(sc2.nextLine() + "\n");
                }

                try {
                    FileWriter w2 = new FileWriter(doc2Path);
                    w2.write(string);
                    w2.close();
                    AuthenticityButton.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Se ha cargado correctamente el documento.");
                } catch (IOException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar cargar el archivo, por favor intente de nuevo.");
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar crear el archivo, por favor intente de nuevo.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "El archivo seleccionado debe ser .txt.\nPor favor seleccione un archivo de extensión .txt.");
        }
    }
    
    public void addDocument(){
        String names[] = new String[2];
        if (checkIfDoc1() == false && checkIfDoc2() == true) {
            addDoc1(names);
        }
        if(checkIfDoc1() == true && checkIfDoc2() == false){
            addDoc2(names);
        }
        if(checkIfDoc1() == false && checkIfDoc2() == false){
            loadFiles();
        }
        
        documentsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
        documentsComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }

    ////////////// PASAR A CLASE FUNCIONES//////////////
    
    public String readDoc(String path){
        File doc = new File(path); 
        String string = "";
        Scanner scanner;
        try {
            scanner = new Scanner(doc);
            while(scanner.hasNextLine()){
                string = string.concat(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return string;
    }
    
    public boolean checkIfDoc1(){
        String path = "test\\doc1.txt";
        File doc1 = new java.io.File(path);
        if(!doc1.exists()){
            return false;
        }else{
            return true;
        }    
    }
    
    public boolean checkIfDoc2(){
        String path = "test\\doc2.txt";
        File doc2 = new java.io.File(path);
        if(!doc2.exists()){
            return false;
        }else{
            return true;
        }    
    }

    public void loadFiles() {
        
/////// !!!!!!!!!!!!OJOOOOO FALTA AGRGAR CONDICIONAL POR SI SE CANCELA LA CARGA DEL ARCHIVO!!!!!!!!!!!!
////// o algo para manejar el null pointer exception.

////// cambiar por addDoc1 y addDoc2
        
        JOptionPane.showMessageDialog(null, "Seleccione al menos un documento.");
        
        chooser.showOpenDialog(null);
        File doc = chooser.getSelectedFile();
        String doc1Name = doc.getName();
        String names[] = new String[2];

        
        String doc1Path = "test\\doc1.txt";
        
        if(doc.isFile()){
            names[0] = doc1Name + " - doc1";
            String fileName = doc.getAbsolutePath();
            try {
                Scanner sc1 = new Scanner(doc);
                String string = "";
                while (sc1.hasNextLine()){
                    string = string.concat(sc1.nextLine() + "\n"); 
                }
                
                try {
                    FileWriter w1 = new FileWriter(doc1Path);
                    w1.write(string);
                    w1.close();
                    WordCounterButton.setEnabled(true);
                    WordSearchButton.setEnabled(true);
                    FrequentWords.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar cargar el archivo, por favor intente de nuevo.");
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar crear el archivo, por favor intente de nuevo.");
            }

        }else{
            JOptionPane.showMessageDialog(null, "El archivo seleccionado debe ser .txt.\nPor favor seleccione un archivo de extensión .txt.");
        }
        
        int reply = JOptionPane.showConfirmDialog(rootPane, "Desea agregar otro documento?\nRecuerde que para comprobar la autenticidad de un documento, debe haber cargado dos "
                + "(2) documentos.", "Mensaje" ,JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_NO_OPTION){
            
            String doc2Path = "test\\doc2.txt";
            JOptionPane.showMessageDialog(null, "Seleccione el segundo documento.");

            chooser.showOpenDialog(null);
            File doc2 = chooser.getSelectedFile();
            String doc2Name = doc2.getName();
            
            if(doc2.isFile()){
                names[1] = doc2Name +" - doc2";
                String fileName = doc.getAbsolutePath();
                try {
                    Scanner sc2 = new Scanner(doc2);
                    String string = "";
                    while (sc2.hasNextLine()) {
                        string = string.concat(sc2.nextLine() + "\n");
                    }

                    try {
                        FileWriter w2 = new FileWriter(doc2Path);
                        w2.write(string);
                        w2.close();
                        AuthenticityButton.setEnabled(true);
                    } catch (IOException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar cargar el archivo, por favor intente de nuevo.");
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar crear el archivo, por favor intente de nuevo.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "El archivo seleccionado debe ser .txt.\nPor favor seleccione un archivo de extensión .txt.");
            } 
        }else{
            JOptionPane.showMessageDialog(null, "Ha decidido ingresar un solo documento.\nPara ingresar a la funcionalidad Anti-plagios, debe ingresar dos documentos.");
        }
        documentsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
        documentsComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }
    
    JFileChooser chooser = new JFileChooser();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        hidebar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LoadFilesButton = new javax.swing.JButton();
        WordCounterButton = new javax.swing.JButton();
        WordSearchButton = new javax.swing.JButton();
        AuthenticityButton = new javax.swing.JButton();
        FrequentWords = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        FileLoaderButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        wordCounterButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        documentsComboBox = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        wordField = new javax.swing.JTextField();
        searchWord = new javax.swing.JButton();
        results = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        documentsComboBox2 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CODE4U READER");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hidebar.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CODE4U READER");

        javax.swing.GroupLayout hidebarLayout = new javax.swing.GroupLayout(hidebar);
        hidebar.setLayout(hidebarLayout);
        hidebarLayout.setHorizontalGroup(
            hidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hidebarLayout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );
        hidebarLayout.setVerticalGroup(
            hidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(hidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 710, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        LoadFilesButton.setText("Cargar archivos");
        LoadFilesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFilesButtonActionPerformed(evt);
            }
        });

        WordCounterButton.setText("Contar palabras");
        WordCounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WordCounterButtonActionPerformed(evt);
            }
        });

        WordSearchButton.setText("Buscar palabras");
        WordSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WordSearchButtonActionPerformed(evt);
            }
        });

        AuthenticityButton.setText("Anti-Plagios");
        AuthenticityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthenticityButtonActionPerformed(evt);
            }
        });

        FrequentWords.setText("Palabras Frec.");
        FrequentWords.setActionCommand("Palabras frec.");
        FrequentWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrequentWordsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WordCounterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(WordSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AuthenticityButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FrequentWords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LoadFilesButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(LoadFilesButton)
                .addGap(25, 25, 25)
                .addComponent(WordCounterButton)
                .addGap(25, 25, 25)
                .addComponent(WordSearchButton)
                .addGap(25, 25, 25)
                .addComponent(AuthenticityButton)
                .addGap(25, 25, 25)
                .addComponent(FrequentWords)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 320));

        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        label1.setText("Para comenzar, debes cargar al menos un (1) archivo para poder acceder a las siguientes funcionalidades: ");

        label2.setText("- Contar Palabras");

        label4.setText("- Buscar Palabras");

        label5.setText("- Palabras Frecuentes");

        label6.setText("Si deseas comprobar la autenticidad de tus documentos con nuestra funcionalidad Anti-Plagios, ");

        label7.setText("debes seleccionar dos (2) documentos.");

        FileLoaderButton.setText("Cargar archivos");
        FileLoaderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileLoaderButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel7.setText("Carga de archivos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(299, 299, 299)
                                .addComponent(FileLoaderButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(FileLoaderButton)
                .addGap(22, 22, 22))
        );

        tabbedPane.addTab("tab1", jPanel2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel2.setText("Contar palabras");

        wordCounterButton.setText("Contar palabras");
        wordCounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordCounterButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Seleccione el archivo:");

        documentsComboBox.setEditable(true);
        documentsComboBox.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                documentsComboBoxComponentHidden(evt);
            }
        });
        documentsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentsComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(wordCounterButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(documentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(documentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(wordCounterButton)
                .addGap(25, 25, 25))
        );

        tabbedPane.addTab("tab2", jPanel4);

        jLabel3.setText("Por favor, ingrese la palabra que desea buscar en el texto:");

        wordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordFieldActionPerformed(evt);
            }
        });
        wordField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                wordFieldPropertyChange(evt);
            }
        });
        wordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                wordFieldKeyReleased(evt);
            }
        });

        searchWord.setText("Buscar palabra");
        searchWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchWordActionPerformed(evt);
            }
        });

        results.setText("*Resultado*");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel5.setText("Buscar palabra");

        jLabel10.setText("Por favor, seleccione el documento");

        documentsComboBox2.setEditable(true);
        documentsComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentsComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(searchWord))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(results, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(wordField)
                            .addComponent(documentsComboBox2, 0, 269, Short.MAX_VALUE))
                        .addGap(27, 27, 27))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(documentsComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(wordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(results)
                .addGap(69, 69, 69)
                .addComponent(searchWord)
                .addContainerGap())
        );

        tabbedPane.addTab("tab3", jPanel5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel6.setText("Anti-Plagios");

        jLabel8.setText("*Resultado*");

        jButton2.setText("Comprobar autenticidad");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel6))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jButton2)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(83, 83, 83))
        );

        tabbedPane.addTab("tab5", jPanel7);

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel9.setText("Palabras más frecuentes");

        jButton3.setText("Buscar palabras");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jButton3))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel9)))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(81, 81, 81))
        );

        tabbedPane.addTab("tab4", jPanel6);

        getContentPane().add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 700, 280));

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setText("Cargar archivos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText(" ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem4.setText("Cerrar");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem5.setText("Personalizar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem3.setText("Eliminar documentos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem6.setText("Agregar documentos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoadFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFilesButtonActionPerformed
        
        loadFiles();
        
    }//GEN-LAST:event_LoadFilesButtonActionPerformed

    private void FileLoaderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileLoaderButtonActionPerformed
        loadFiles();
    }//GEN-LAST:event_FileLoaderButtonActionPerformed

    private void WordCounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WordCounterButtonActionPerformed
        tabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_WordCounterButtonActionPerformed

    private void WordSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WordSearchButtonActionPerformed
        tabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_WordSearchButtonActionPerformed

    private void AuthenticityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthenticityButtonActionPerformed
        tabbedPane.setSelectedIndex(3);
    }//GEN-LAST:event_AuthenticityButtonActionPerformed

    private void FrequentWordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrequentWordsActionPerformed
        tabbedPane.setSelectedIndex(4);
    }//GEN-LAST:event_FrequentWordsActionPerformed

    private void wordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFieldActionPerformed

    }//GEN-LAST:event_wordFieldActionPerformed

    private void searchWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchWordActionPerformed
        
        if(wordField.getText().isBlank() || wordField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar una palabra.");
        }else{
            String word = wordField.getText();
            String name = documentsComboBox.getSelectedItem().toString();
            
            
            String docPath = "test\\"+name.split("- ")[1]+".txt";
            String string = readDoc(docPath);
            
            String wordSearchResults = "************Aqui va el resultado de la busqueda*************";
            results.setText(wordSearchResults);
        }    
        
    }//GEN-LAST:event_searchWordActionPerformed

    private void wordFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_wordFieldPropertyChange

    }//GEN-LAST:event_wordFieldPropertyChange

    private void wordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wordFieldKeyReleased
        if(wordField.getText().length()>0){
            searchWord.setEnabled(true);
        }else{
            searchWord.setEnabled(false);
        }
    }//GEN-LAST:event_wordFieldKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        loadFiles();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JColorChooser.showDialog(null, "Seleccione un color de fondo", Color.lightGray);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void documentsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_documentsComboBoxActionPerformed

    private void documentsComboBoxComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_documentsComboBoxComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_documentsComboBoxComponentHidden

    private void wordCounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordCounterButtonActionPerformed
        
        String name = documentsComboBox.getSelectedItem().toString();
        String docPath = "test\\"+name.split("- ")[1]+".txt";
        System.out.println(docPath);
        
        String string = readDoc(docPath);

        
        
        
    }//GEN-LAST:event_wordCounterButtonActionPerformed

    private void documentsComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentsComboBox2ActionPerformed
        
    }//GEN-LAST:event_documentsComboBox2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        
        if(!checkIfDoc1()){
            
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        addDocument();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AuthenticityButton;
    private javax.swing.JButton FileLoaderButton;
    private javax.swing.JButton FrequentWords;
    private javax.swing.JButton LoadFilesButton;
    private javax.swing.JButton WordCounterButton;
    private javax.swing.JButton WordSearchButton;
    private javax.swing.JComboBox<String> documentsComboBox;
    private javax.swing.JComboBox<String> documentsComboBox2;
    private javax.swing.JPanel hidebar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel results;
    private javax.swing.JButton searchWord;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton wordCounterButton;
    private javax.swing.JTextField wordField;
    // End of variables declaration//GEN-END:variables
}
