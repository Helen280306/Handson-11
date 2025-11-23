package latihan4_isp;

public class ISPPractice {
    public static void main(String[] args) {

        // ===== PART 1: BAD PRACTICE - Melanggar ISP =====
        System.out.println("=== BAD PRACTICE: Melanggar ISP ===\n");

        System.out.println("--- Testing PDF Document ---");
        latihan4_isp.bad.Document pdf = new latihan4_isp.bad.PDFDocument("Contract.pdf");
        pdf.read();
        pdf.print();

        System.out.println("\nTrying to edit PDF (not supported):");
        try {
            pdf.edit("New content");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- Testing Image Document ---");
        latihan4_isp.bad.Document image = new latihan4_isp.bad.ImageDocument("Photo.jpg");
        image.read();

        System.out.println("\nTrying to print image (not supported):");
        try {
            image.print();
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("Document interface terlalu BESAR (FAT INTERFACE):");
        System.out.println("1. read() - semua dokumen butuh ✓");
        System.out.println("2. edit() - hanya Word & Spreadsheet butuh ✗");
        System.out.println("3. print() - PDF, Word, Spreadsheet butuh (Image tidak) ✗");
        System.out.println("4. calculate() - hanya Spreadsheet butuh ✗");
        System.out.println("5. resize() - hanya Image butuh ✗");
        System.out.println("\nPDF & Image dipaksa implement method yang tidak digunakan!");
        System.out.println("Banyak method yang hanya throw UnsupportedOperationException!");
        System.out.println("Interface tidak fleksibel = MELANGGAR ISP!");

        System.out.println("\n" + "=".repeat(70));


        // ===== PART 2: GOOD PRACTICE - Mengikuti ISP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti ISP ===\n");


        System.out.println("--- Testing PDF Document ---");
        latihan4_isp.good.PDFDocument goodPdf = new latihan4_isp.good.PDFDocument("Contract.pdf");
        goodPdf.read();
        goodPdf.print();


        System.out.println("\n--- Testing Word Document ---");
        latihan4_isp.good.WordDocument word =
                new latihan4_isp.good.WordDocument("Report.docx");
        word.read();
        word.edit("Updated content for report");
        word.print();


        System.out.println("\n--- Testing Spreadsheet Document ---");
        latihan4_isp.good.SpreadsheetDocument sheet =
                new latihan4_isp.good.SpreadsheetDocument("Budget.xlsx");
        sheet.read();
        sheet.edit("A1: 1000");
        sheet.calculate("SUM(A1:A10)");
        sheet.print();


        System.out.println("\n--- Testing Image Document ---");
        latihan4_isp.good.ImageDocument img =
                new latihan4_isp.good.ImageDocument("Photo.jpg");
        img.read();
        img.resize(800, 600);


        System.out.println("\n--- Polymorphic Usage ---");
        latihan4_isp.good.Readable[] readers = {
                new latihan4_isp.good.PDFDocument("Doc1.pdf"),
                new latihan4_isp.good.ImageDocument("Image1.jpg")
        };

        for (latihan4_isp.good.Readable r : readers) {
            r.read();
        }


        System.out.println("\nPrinting all printable documents:");
        latihan4_isp.good.Printable[] printables = {
                new latihan4_isp.good.PDFDocument("Doc.pdf"),
                new latihan4_isp.good.WordDocument("Report.docx"),
                new latihan4_isp.good.SpreadsheetDocument("Data.xlsx")
        };

        for (latihan4_isp.good.Printable p : printables) {
            p.print();
        }


        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Focused - Setiap interface punya capability yang jelas dan spesifik");
        System.out.println("✓ Flexible - Class hanya implement capability yang benar-benar dimiliki");
        System.out.println("✓ Type-safe - Compile-time checking, bukan runtime exception");
        System.out.println("✓ Clean - Tidak ada method yang throw UnsupportedOperationException");
        System.out.println("✓ Extensible - Mudah tambah document type baru dengan capability mix & match");
    }
}
