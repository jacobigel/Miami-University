import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * A simple database that contains fixed size records. Each record has the
 * following information: 1. An integer with unique ID 2. A 15-character long
 * name 3. An integer for salary for the person.
 *
 * @note The size (in bytes) of each record is 4 + 15 * 2 + 4 = 38 bytes
 */
public class SimpleDb {
    /**
     * A simple record to ease reading/writing data to the database.
     */
    static class Record {
        // An unique ID associated with this record
        public int id;
        // A fixed-length name or string
        public String name;
        // A salary associated with this record.
        public int salary;

        @Override
        public String toString() {
            return String.format("%2d, %-15s, %6d", id, name.trim(), salary);
        }
    }

    /**
     * A fixed size record. Each record is 38 bytes in size.
     */
    private static final int RECORD_SIZE = 38;

    /**
     * The random access file that is used to read/write fixed-size records.
     */
    RandomAccessFile db;

    public SimpleDb(String path) throws FileNotFoundException {
        db = new RandomAccessFile(new File(path), "rw");
    }

    /**
     * Find the number of records in this database.
     * 
     * @return The number of records in the database.
     * @throws IOException Exposes exceptions during I/O.
     */
    public long getRecordCount() throws IOException {
        return db.length() / RECORD_SIZE;
    }

    /**
     * Method to write a given record at a given index position.
     * 
     * @param recNum The zero-based record position where the record is to be
     *               written.
     * @param rec    The record to be written.
     * @throws IOException Any exception that may occur during I/O.
     */
    public void write(int recNum, Record rec) throws IOException {
        db.seek(recNum * RECORD_SIZE);
        db.writeInt(rec.id);
        // Convert string to a maximum of 30-bytes
        final byte[] nameBytes = rec.name.getBytes();
        final byte[] rawBytes = new byte[30];
        System.arraycopy(nameBytes, 0, rawBytes, 0, nameBytes.length);
        // Write exactly 30 bytes
        db.write(rawBytes);
        // Write salary
        db.writeInt(rec.salary);
    }
    
    /**
     * Write the supplied array to a given file in binary format using an
     * ObjectOutputStream.
     * 
     * @param list - The array of employees to be written
     * @throws IOException - Exceptions may be thrown due to I/O errors
     */
    public void write(Employee[] list) throws IOException {
        int i = 0;
        for (Employee e : list) {
            Record rec = new Record();
            rec.id = e.id;
            rec.name = e.name;
            rec.salary = e.salary;
            write(i++, rec);
        }
    }


    /**
     * Method to load a given record at the given index position.
     * 
     * @param recNum The zero-based record position from where the record is to
     *               be read.
     * @return The record containing data read from the file.
     * @throws IOException Any exception that may occur during I/O.
     */
    public Record read(int recNum) throws IOException {
        // Review the write() method first.
        // Use the operations corresponding to the write operations to
        // read a record from the database.
        db.seek(recNum * RECORD_SIZE);
        Record rec = new Record();
        rec.id = db.readInt();
        final byte[] rawBytes = new byte[30];
        db.read(rawBytes);
        rec.name = new String(rawBytes);
        rec.salary = db.readInt();
        return rec;
    }
    

    /**
     * Swaps records (i.e. data) at two given record positions.
     * 
     * @param recNum1 The first zero-based record position.
     * @param recNum2 The second zero-based record position.
     * @throws IOException Exceptions may be throws due to I/O errors.
     */
    public void swap(int recNum1, int recNum2) throws IOException {
        // First read the data for the record
        Record rec1 = read(recNum1);
        Record rec2 = read(recNum2);
        
        // Write the records in a different location
        write(recNum1, rec2);
        write(recNum2, rec1);
    }



    /**
     * Sort the records based on the ID column. Use a simple sorting algorithm
     * to do the sorting.
     * 
     * @throws IOException Just exposes exceptions (if any)
     */
    public void sort() throws IOException {
        // Get a count of the records
        final int recCount = (int) getRecordCount();
        for (int i = 0; (i < recCount); i++) {
            Record recI = read(i);
            for (int j = i + 1; (j < recCount); j++) {
                Record recJ = read(j);
                if (recJ.salary < recI.salary) {
                    swap(i, j);
                    recI = recJ;
                }
            }
        }
        
        
    }
}
