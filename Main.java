import Model.*;
import Controller.SIAController;
import View.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<User> users = createDummyData();
        SIAController controller = new SIAController(users);

        Menu menu = new Menu(controller);
        menu.showMenu();
    }

    private static List<User> createDummyData() {

        // Dummy Mata Kuliah
        MataKuliah matkul1 = new MataKuliah("MK-001", 4, "Algoritma Pemrograman");
        MataKuliah matkul2 = new MatkulPilihan("MK-002", 2, "Artificial Intellegence", 10);

        // Dummy Presensi
        Presensi presensi1 = new Presensi("2024-10-04", Kehadiran.HADIR);
        Presensi presensi2 = new Presensi("2024-10-05", Kehadiran.ALPHA);
        List<Presensi> presensiList = new ArrayList<>(Arrays.asList(presensi1, presensi2));

        // Dummy MatkulAmbil
        MatkulAmbil matkulAmbil1 = new MatkulAmbil(matkul1, presensiList, 90, 75, 80);
        MatkulAmbil matkulAmbil2 = new MatkulAmbil(matkul2, presensiList, 65, 70, 95);
        List<MatkulAmbil> matkulAmbilList = new ArrayList<>(Arrays.asList(matkulAmbil1, matkulAmbil2));

        // Dummy Mahasiswa
        Sarjana mhsSarjana = new Sarjana("Rudicc", "Kupang", "2004-02-12", "08421534351", "NIM-001", "Informatika", matkulAmbilList);
        Magister mhsMagister = new Magister("Gaming", "Toraja", "1945-02-11", "087912133445", "NIM-002", "Sistem Informasi", matkulAmbilList, "AI in Healthcare");

        // Membuat data dummy PresensiStaff
        PresensiStaff presensiStaff1 = new PresensiStaff("2024-01-01", Kehadiran.HADIR, "08:00");
        List<PresensiStaff> presensiStaffList = new ArrayList<>(Arrays.asList(presensiStaff1));

        // Membuat data dummy MatkulAjar
        MatkulAjar matkulAjar1 = new MatkulAjar(matkul1, presensiStaffList);
        List<MatkulAjar> matkulAjarList = new ArrayList<>(Arrays.asList(matkulAjar1));

        // Membuat data dummy Dosen
        DosenTetap dosenTetap = new DosenTetap("Dosen Tetap 1", "Surabaya", "1975-01-01", "08123456781", "NIK001", "Informatika", matkulAjarList, 10000000);
        DosenHonorer dosenHonorer = new DosenHonorer("Dosen Honor 1", "Yogyakarta", "1980-01-01", "08123456782", "NIK002", "Sistem Informasi", matkulAjarList, 300000);

        // Membuat data dummy Karyawan
        Karyawan karyawan = new Karyawan("Staff 1", "Malang", "1985-01-01", "08123456783", "NIK003", 5000000, presensiStaffList);

        // Membuat list users (data dummy untuk controller)
        List<User> users = new ArrayList<>();
        users.add(mhsSarjana);
        users.add(mhsMagister);
        users.add(dosenTetap);
        users.add(dosenHonorer);
        users.add(karyawan);

        return users;
    }

}