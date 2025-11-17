package latihan4_isp.good;

// Interface untuk capability EDITING
// HANYA document yang bisa diedit yang implement ini
public interface Editable {

    /*
     * Edit document content
     * Hanya Word dan Spreadsheet yang implement ini
     *
     * @param content - New content to write
     */
    void edit(String content);
}
