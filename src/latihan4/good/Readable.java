package latihan4_isp.good;

// Interface kecil dan focused untuk capability READING
// Semua document type bisa implement ini
public interface Readable {

    /*
     * Read document content
     * Semua jenis dokumen harus bisa dibaca
     */
    void read();
}
