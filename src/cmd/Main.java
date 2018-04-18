package cmd;


import java.util.*;

public class Main {

    static Map<Kaca, Integer> listKaca = new HashMap();
    static Map<Kusen, Integer> listKusen = new HashMap();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t;
        int sum = 0;
        Boolean login = false;
        String user, pass;
        Pekerja pekerja = new Pekerja();
        ConnectSQL sql = new ConnectSQL();
        CSV csv = new CSV();

        int menu = 0;
        while (menu != 8) {

            System.out.println("Pilih kegiatan");
            System.out.println("1. Kebutuhan kaca");
            System.out.println("2. Kebutuhan kusen");
            System.out.println("3. Kebutuhan pekerja");
            System.out.println("4. Kebutuhan waktu");
            System.out.println("5. Login");
            System.out.println("6. Save & upload kaca");
            System.out.println("7. Save & upload kusen");
            System.out.println("8. Keluar");
            System.out.print("Pilihan anda  :");
            menu = Integer.parseInt(in.next());
            switch (menu) {
                case 1: {
                    listKaca=Hitung.hitungKaca();
                }
                break;
                case 2: {
                    listKusen=Hitung.hitungKusen();
                }
                break;
                case 3:
                    System.out.print("Berapa lama proyek harus dikerjakan?");
                    int jw = in.nextInt();
                    System.out.println("Jumlah pekerja : " + pekerja.getPekerja(sum, jw));

                    break;
                case 4:

                    System.out.print("Berapa banyak pekerja yang ada?");
                    int jk = in.nextInt();
                    System.out.println("Waktu dibutuhkan : " + pekerja.getWaktu(sum, jk));

                    break;
                case 5: {
                    System.out.print("Username    :");
                    user = in.next();
                    System.out.print("Password    :");
                    pass = in.next();
                    try {
                        sql.connect(user, pass,"mks");
                        login = true;
                    } catch (Exception ex) {

                    }
                }
                break;
                case 6: {
                    try {
                        if (!listKaca.isEmpty() && login==true) {
                            csv.writeKaca(listKaca, "C:\\Users\\IRS37\\Google Drive\\PrototypeAKS\\kaca.csv");
                            System.out.println("Save berhasil");
                            sql.insertListKaca(listKaca);
                        } else {
                            //System.out.println("Tidak ada data");
                        }
                    } catch (Exception e) {
                        //System.out.println("Kosong");
                    }
                }
                break;
                case 7: {
                    try {
                        if (!listKusen.isEmpty() && login==true) {
                            csv.writeKusen(listKusen, "C:\\Users\\IRS37\\Google Drive\\PrototypeAKS\\kusen.csv");
                            System.out.println("Save berhasil");
                            sql.insertListKusen(listKusen);
                        } else {
                            //System.out.println("Tidak ada data");
                        }
                    } catch (Exception e) {
                        //System.out.println("Kosong");
                    }
                }
                break;
                case 8:
                    break;
                default:
                    break;
            }
            System.out.println();
        }
    }
}
