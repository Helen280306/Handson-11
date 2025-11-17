package latihan4_isp.bad;

public interface Document {

    // Capability 1: Reading (semua document butuh)
    void read();

    // Capability 2: Editing (hanya Word & Spreadsheet butuh)
    void edit(String content);

    // Capability 3: Printing (PDF, Word, Spreadsheet butuh, Image tidak)
    void print();

    // Capability 4: Calculate (hanya Spreadsheet butuh)
    void calculate(String formula);

    // Capability 5: Resize (hanya Image butuh)
    void resize(int width, int height);
}
