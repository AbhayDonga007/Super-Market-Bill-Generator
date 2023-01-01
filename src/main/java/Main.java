import java.util.Date;
import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.text.Format;
import java.text.SimpleDateFormat;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

class product {
    String Product_name;
    double Product_price;
    int Quantity;
    product next;

    product() {
    }

    product(String name, double price, int Qauntity) {
        this.Product_name = name;
        this.Product_price = price;
        this.Quantity = Qauntity;
        this.next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        System.out.print("\n\t\t\t\t\t\t\t --------------------------------------------------------------------\n");
        System.out.print("\t\t\t\t\t\t\t|                                                                    |\n");
        System.out.print("\t\t\t\t\t\t\t|                                                                    |\n");
        System.out.print("\t\t\t\t\t\t\t|                        Welcome to Super Market                     |\n");
        System.out.print("\t\t\t\t\t\t\t|                                                                    |\n");
        System.out.print("\t\t\t\t\t\t\t|                                                                    |\n");
        System.out.print("\t\t\t\t\t\t\t --------------------------------------------------------------------\n");

        product head = new product("Colgate Toothpaste", 100, 100);
        head.next = new product("DantKanti Toothpaste", 120, 150);
        head.next.next = new product("Dettol Soap", 168, 200);
        head.next.next.next = new product("Kissan Ketchup", 99, 120);
        head.next.next.next.next = new product("Apsara Pencil", 20, 300);
        head.next.next.next.next.next = new product("Classmate Books", 650, 90);
        head.next.next.next.next.next.next = new product("Camel Water Color", 500, 60);
        head.next.next.next.next.next.next.next = new product("Basmati Rice", 90, 55);
        head.next.next.next.next.next.next.next.next = new product("Madhur Sugar", 40, 190);
        head.next.next.next.next.next.next.next.next.next = new product("Jivaraj Tea", 450, 220);

        class Selected_product {
            String Product_name;
            double price;
            int Qauntity;
            Selected_product next;

            Selected_product(String name, double price, int Qauntity) {
                this.Product_name = name;
                this.price = price;
                this.Qauntity = Qauntity;
                this.next = null;
            }
        }
        Selected_product catalogue_head = null;

        Scanner sc = new Scanner(System.in);

        while (true) {
            int choice;
            System.out.print("\n\t\t\t\t\t\t\tEnter your choice: \n\t\t\t\t\t\t\t1: Display available products in Super Market\n\t\t\t\t\t\t\t2: Create Catalogue\n\t\t\t\t\t\t\t3: Display the items of the Catalogue\n\t\t\t\t\t\t\t4: Delete or Change Qty of item in the Catalogue\n\t\t\t\t\t\t\t5: Final Payment\n\t\t\t\t\t\t\tEnter here: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print(
                            "\n\t\t\t\t\t\t\t----------------------------------------------------------------------------\n\t\t\t\t\t\t\tProduct Name\t\t\t\t\t\t\tPrice\t\tAvailable Quantity\n\t\t\t\t\t\t\t----------------------------------------------------------------------------\n");
                    product ptr = head;
                    while (ptr != null) {
                        System.out.print("\t\t\t\t\t\t\t"+ptr.Product_name);
                        for (int i = 0; i < 40 - ptr.Product_name.length(); i++)
                            System.out.print(" ");
                        System.out.print(ptr.Product_price + "\t\t\t" + ptr.Quantity + "\n");
                        ptr = ptr.next;
                    }
                    System.out.print("\t\t\t\t\t\t\t----------------------------------------------------------------------------\n");
                }
                break;

                case 2: {
                    System.out.print("\n\t\t\t\t\t\t\t----------------------------------------------------------------------------");
                    while (true) {
                        int choice_2;
                        System.out.print("\n\t\t\t\t\t\t\tEnter your choice:\n\t\t\t\t\t\t\t1: See the Products and add to Bag\n\t\t\t\t\t\t\t2: Search for Product and add to Bag\n\t\t\t\t\t\t\tEnter here: ");
                        choice_2 = sc.nextInt();

                        switch (choice_2) {
                            case 1: {
                                System.out.print(
                                        "\n\t\t\t\t\t\t\t----------------------------------------------------------------------------\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tProduct Name\t\t\t\t\t\t\tPrice\t\tAvailable Qauntity\n\t\t\t\t\t\t\t----------------------------------------------------------------------------\n");
                                product ptr = head;
                                while (ptr != null) {
                                    System.out.print("\t\t\t\t\t\t\t"+ptr.Product_name);
                                    for (int i = 0; i < 40 - ptr.Product_name.length(); i++)
                                        System.out.print(" ");
                                    System.out.print(ptr.Product_price + "\t\t\t" + ptr.Quantity + "\n");
                                    ptr = ptr.next;
                                }

                                System.out.print("\n\t\t\t\t\t\t\tEnter the Product Name Correctly: ");
                                String Desired_product = sc.nextLine();
                                Desired_product = sc.nextLine();

                                Selected_product ptr2 = catalogue_head;
                                while (ptr2 != null) {
                                    if (ptr2.Product_name.equalsIgnoreCase(Desired_product)) {
                                        break;
                                    }
                                    ptr2 = ptr2.next;
                                }

                                ptr = head;
                                while (ptr != null) {
                                    if (ptr.Product_name.equalsIgnoreCase(Desired_product)) {
                                        break;
                                    }
                                    ptr = ptr.next;
                                }

                                if (ptr2 == null) {
                                    if (ptr != null) {
                                        System.out.print("\t\t\t\t\t\t\tEnter a Quantity: ");
                                        int Qauntity = sc.nextInt();
                                        ptr.Quantity -= Qauntity;
                                        Selected_product node = new Selected_product(ptr.Product_name, ptr.Product_price, Qauntity);
                                        if (catalogue_head == null) {
                                            catalogue_head = node;
                                        } else {
                                            Selected_product ptr1 = catalogue_head;
                                            while (ptr1.next != null) {
                                                ptr1 = ptr1.next;
                                            }
                                            ptr1.next = node;
                                        }

                                        System.out.println("\t\t\t\t\t\t\tProduct added to your Bag...");
                                    } else {
                                        System.out.print("\n\t\t\t\t\t\t\tThere is not any product with this name \"" + Desired_product + "\"\n");
                                    }
                                } else {
                                    System.out.print("\t\t\t\t\t\t\tEnter a Quantity: ");
                                    int Qauntity = sc.nextInt();
                                    ptr2.Qauntity += Qauntity;
                                    ptr.Quantity -= Qauntity;
                                    System.out.println("\t\t\t\t\t\t\tProduct added to your Bag...");
                                }
                            }
                            break;

                            case 2: {
                                String Product_name;
                                System.out.print("\t\t\t\t\t\t\tEnter a name of the Product: ");
                                Product_name = sc.nextLine();
                                Product_name = sc.nextLine();

                                Selected_product ptr2 = catalogue_head;
                                while (ptr2 != null) {
                                    if (ptr2.Product_name.equalsIgnoreCase(Product_name)) {
                                        break;
                                    }
                                    ptr2 = ptr2.next;
                                }

                                product ptr = head;
                                while (ptr != null) {
                                    if (ptr.Product_name.equalsIgnoreCase(Product_name)) {
                                        break;
                                    }
                                    ptr = ptr.next;
                                }

                                if (ptr != null) {
                                    System.out.print("\n\t\t\t\t\t\t\tProduct exist...");
                                    System.out.print(
                                            "\n\t\t\t\t\t\t\t-----------------------------------------------------------------------------\n\t\t\t\t\t\t\tProduct Name: "
                                                    +"\t\t\t\t\t\t\t"+ ptr.Product_name + "\n\t\t\t\t\t\t\tPrice: " + ptr.Product_price
                                                    + "\n\t\t\t\t\t\t\tAvailable Qauntity: " + ptr.Quantity
                                                    + "\n\t\t\t\t\t\t\t-----------------------------------------------------------------------------\n");
                                    int opinion;
                                    System.out.print("\n\t\t\t\t\t\t\tDo you want to add it into Bag ?\n\t\t\t\t\t\t\t1: YES\n\t\t\t\t\t\t\t2: NO\n\t\t\t\t\t\t\tEnter here: ");
                                    opinion = sc.nextInt();

                                    if (opinion == 1) {
                                        if (ptr2 == null) {
                                            System.out.print("\t\t\t\t\t\t\tEnter a Quantity: ");
                                            int Qauntity = sc.nextInt();

                                            ptr.Quantity -= Qauntity;
                                            Selected_product node = new Selected_product(ptr.Product_name, ptr.Product_price,
                                                    Qauntity);
                                            if (catalogue_head == null) {
                                                catalogue_head = node;
                                            } else {
                                                Selected_product ptr1 = catalogue_head;
                                                while (ptr1.next != null) {
                                                    ptr1 = ptr1.next;
                                                }
                                                ptr1.next = node;
                                            }
                                        } else {
                                            System.out.print("\t\t\t\t\t\t\tEnter a Quantity: ");
                                            int Qauntity = sc.nextInt();
                                            ptr2.Qauntity += Qauntity;
                                            ptr.Quantity -= Qauntity;
                                        }
                                        System.out.println("\t\t\t\t\t\t\tProduct added to your Bag...");
                                    }
                                } else {
                                    System.out.print("\n\t\t\t\t\t\t\tProduct doesn't exist...\n");
                                }
                            }

                            break;
                        }

                        int repeat;
                        System.out.print("\n\t\t\t\t\t\t\tDo you want to add more products in Bag ?\n\t\t\t\t\t\t\t1: YES\n\t\t\t\t\t\t\t2: NO\n\t\t\t\t\t\t\tEnter here: ");
                        repeat = sc.nextInt();

                        if (repeat == 2) {
                            System.out.println("\t\t\t\t\t\t\t----------------------------------------------------------------------------\n");
                            break;
                        } else if (repeat == 1) {
                            continue;
                        }
                    }
                }
                break;

                case 3: {
                    if (catalogue_head == null) {
                        System.out.println("\n\t\t\t\t\t\t\tCatalogue is empty...");
                        continue;
                    }

                    System.out.println(
                            "\n\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------\n\t\t\t\t\t\t\tProduct Name\t\t\t\t\t\tQuantity\t\tPrice\t\t\tTotal\n\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------\n");
                    double Amount = 0;
                    Selected_product ptr = catalogue_head;
                    while (ptr != null) {
                        System.out.print("\t\t\t\t\t\t\t"+ptr.Product_name);
                        for (int i = 0; i < 40 - ptr.Product_name.length(); i++)
                            System.out.print(" ");
                        System.out.print(ptr.Qauntity + "\t\t\t" + ptr.price + "\t\t\t" + ptr.Qauntity * ptr.price + "\n");
                        Amount += ptr.Qauntity * ptr.price;
                        ptr = ptr.next;
                    }
                    System.out.println("\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t\t\tAmount\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Amount);
                    System.out.println("\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------\n");
                }
                break;

                case 4: {
                    if (catalogue_head == null) {
                        System.out.println("\n\t\t\t\t\t\t\tCatalogue is empty...");
                        continue;
                    }

                    System.out.println("\n\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------\n\t\t\t\t\t\t\tSr. No.\tProduct Name\t\t\t\t\t\tQuantity\t\tPrice\t\t\tTotal\n\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------\n");
                    double Amount = 0;
                    int k = 1;
                    Selected_product ptr = catalogue_head;
                    while (ptr != null) {
                        System.out.print("\t\t\t\t\t\t\t"+k + "\t" + ptr.Product_name);
                        k++;
                        for (int i = 0; i < 40 - ptr.Product_name.length(); i++)
                            System.out.print(" ");
                        System.out.print(ptr.Qauntity + "\t\t\t" + ptr.price + "\t\t\t" + ptr.Qauntity * ptr.price + "\n");
                        Amount += ptr.Qauntity * ptr.price;
                        ptr = ptr.next;
                    }
                    System.out.println("\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t\t\t\tAmount\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Amount);
                    System.out.println("\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------\n");

                    int index;
                    System.out.print("\t\t\t\t\t\t\tEnter a Index number of the product: ");
                    index = sc.nextInt();
                    int Qauntity = 0;

                    Selected_product previous_ptr = catalogue_head;
                    ptr = catalogue_head;
                    for (int i = 1; i < index; i++) {
                        previous_ptr = ptr;
                        ptr = ptr.next;
                    }

                    int inc_dec = 0;

                    product ptr1 = head;
                    while (ptr1 != null) {
                        if (ptr1.Product_name.equals(ptr.Product_name)) {
                            System.out.print("\t\t\t\t\t\t\tWhat do you want?\n\t\t\t\t\t\t\tPress 1: To Increase Qty\n\t\t\t\t\t\t\tPress 2: To Decrease Qty\n\t\t\t\t\t\t\tEnter here: ");
                            inc_dec = sc.nextInt();
                            System.out.print("\n\t\t\t\t\t\t\tHow many Qauntity? : ");
                            Qauntity = sc.nextInt();

                            if (inc_dec == 1)
                                ptr1.Quantity -= Qauntity;
                            else if (inc_dec == 2)
                                ptr1.Quantity += Qauntity;
                            break;
                        }
                        ptr1 = ptr1.next;
                    }

                    if (inc_dec == 2) {
                        if (ptr.Qauntity == Qauntity) {
                            if (ptr == catalogue_head) {
                                catalogue_head = ptr.next;
                            } else if (ptr.next == null) {
                                previous_ptr.next = null;
                            } else {
                                previous_ptr.next = ptr.next;
                            }
                            System.out.print("\n\t\t\t\t\t\t\tRequest executed...\n");
                        } else if (Qauntity < ptr.Qauntity) {
                            ptr.Qauntity -= Qauntity;
                            System.out.println("\n\t\t\t\t\t\t\tRequest executed...\n");
                        } else {
                            System.out.println("\n\t\t\t\t\t\t\tThere is not enough item in catalogue to delete");
                        }
                    } else if (inc_dec == 1) {
                        ptr.Qauntity += Qauntity;
                    }
                }
                break;

                case 5: {
                    File stock = new File("Stock.txt");
                    FileWriter stock_write = new FileWriter("Stock.txt");

                    product ptr_stock = head;
                    int count = 1;
                    stock_write.write("\t\t\t\t\t\t\tRemaining Stock\n\t\t\t\t\t\t\t----------------------------------------------------------------------------------------\n\t\t\t\t\t\t\tSr.No.\tProduct Name\t\t\t\tPrice\t\tAvailable Qauntity\n\t\t\t\t\t\t\t----------------------------------------------------------------------------------------\n");
                    while (ptr_stock != null) {
                        stock_write.write("\t\t\t\t\t\t\t"+count + "\t" + ptr_stock.Product_name.toUpperCase());
                        for (int i = 0; i < 40 - ptr_stock.Product_name.length(); i++) {
                            stock_write.write(" ");
                        }
                        stock_write.write(ptr_stock.Product_price + "\t\t\t" + ptr_stock.Quantity + "\n");
                        count++;
                        ptr_stock = ptr_stock.next;
                    }
                    stock_write.close();

                    String full_name, mo_no;
                    System.out.print("\n\t\t\t\t\t\t\tEnter your Full name: ");
                    full_name = sc.nextLine();
                    full_name = sc.nextLine();
                    System.out.print("\t\t\t\t\t\t\tEnter your mobile no: ");
                    mo_no = sc.nextLine();

                    Selected_product purchase = catalogue_head;
                    File user = new File(full_name.toUpperCase() + ".txt");
                    FileWriter user_write = new FileWriter(full_name.toUpperCase() + ".txt");
                    count = 1;
                    Format f = new SimpleDateFormat("dd/MM/yyyy");
                    String strDate = f.format(new Date());

                    user_write.write("\t\t\t\t\t\t\tName: " + full_name.toUpperCase() + "\n\t\t\t\t\t\t\tMobile Number: " + mo_no + "\n\t\t\t\t\t\t\tDate: " + strDate
                            + "\n\t\t\t\t\t\t\t---------------------------------------------------------------------------------------------------------------\n\t\t\t\t\t\t\tSr.No.\tProduct Name\t\t\t\t\t\tQuantity\t\tPrice\t\t\tAmount\n\t\t\t\t\t\t\t---------------------------------------------------------------------------------------------------------------\n");

                    System.out.println(
                            "\n\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------\n\t\t\t\t\t\t\tProduct Name\t\t\t\t\t\tQuantity\t\t\tPrice\t\t\tAmount\n\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------\n");
                    double Amount = 0;
                    Selected_product ptr = catalogue_head;
                    while (ptr != null) {
                        System.out.print("\t\t\t\t\t\t\t"+ptr.Product_name);
                        for (int i = 0; i < 40 - ptr.Product_name.length(); i++)
                            System.out.print(" ");
                        System.out.print(ptr.Qauntity + "\t\t\t" + ptr.price + "\t\t\t" + ptr.Qauntity * ptr.price + "\n");
                        Amount += ptr.Qauntity * ptr.price;
                        ptr = ptr.next;
                    }
                    System.out.println("\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t\t\tTotal\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Amount);
                    System.out.println("\t\t\t\t\t\t\t--------------------------------------------------------------------------------------------------------\n");

                    while (purchase != null) {
                        user_write.write("\t\t\t\t\t\t\t"+count + "\t" + purchase.Product_name.toUpperCase());
                        for (int i = 0; i < 40 - purchase.Product_name.length(); i++) {
                            user_write.write(" ");
                        }
                        user_write.write(purchase.Qauntity + "\t\t\t" + purchase.price + "\t\t\t"
                                + purchase.price * purchase.Qauntity + "\n");
                        count++;
                        purchase = purchase.next;
                    }
                    user_write.write(
                            "\t\t\t\t\t\t\t---------------------------------------------------------------------------------------------------------------\n\t\t\t\t\t\t\tTOTAL\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
                                    + Amount
                                    + "\n\t\t\t\t\t\t\t---------------------------------------------------------------------------------------------------------------\n");
                    user_write.close();

                    while (true) {
                        System.out.print("\t\t\t\t\t\t\tEnter a payment value here: ");
                        double payment = sc.nextDouble();
                        if (payment == Amount) {
                            System.out.println(
                                    "\n\t\t\t\t\t\t\tPayment Successful...\n\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tNOTE : Take Your Bill\n\t\t\t\t\t\t\t-----------------------------------------\n\t\t\t\t\t\t\t... THANK YOU FOR VISITING ...");
                            //path where the PDF file will be store
                            PdfWriter writer = new PdfWriter("C:\\Users\\abhay\\IdeaProjects\\BillGenerate\\Invoice.pdf");
                            PdfDocument PdfDoc = new PdfDocument(writer);
                            PdfPage pdfPage = PdfDoc.addNewPage();
                            Document document = new Document(PdfDoc);

                            // table 1
                            float[] pointColumnWidths1 = { 700f };
                            Table table1 = new Table(pointColumnWidths1);

                            Cell cell1 = new Cell();

                            ImageData data = ImageDataFactory.create("D:\\Sem 3 Sub\\Logo.jpg");
                            Image image = new Image(data);
                            image.scaleToFit(150, 150);
                            cell1.add(image.setHorizontalAlignment(HorizontalAlignment.CENTER));
                            table1.addCell(cell1.setBorder(Border.NO_BORDER));

                            Paragraph pr1 = new Paragraph("238 , Vishal Nager So., Varachha Road,\r\n"
                                    + "A. K. Road, Surat-395008\r\n" + "MAIL : supermarket@gmail.com\r\n"
                                    + "Customer Care No : (+91) 7818070999");
                            Cell cell2 = new Cell().add(pr1.setTextAlignment(TextAlignment.CENTER));
                            table1.addCell(cell2.setBorder(Border.NO_BORDER).setBold());

                            for (int i = 0; i < 5; i++)
                                table1.addCell(new Cell().add(" ").setBorder(Border.NO_BORDER));

                            document.add(table1);

                            // table 2
                            float[] pointColumnWidths2 = { 100f, 400f, 100f, 400f };
                            Table table2 = new Table(pointColumnWidths2);

                            table2.addCell(
                                    new Cell().add(new Paragraph("Name:").setBold()).setTextAlignment(TextAlignment.LEFT));
                            table2.addCell(new Cell().add(new Paragraph(full_name.toUpperCase()))
                                    .setTextAlignment(TextAlignment.LEFT));
                            table2.addCell(new Cell().add(new Paragraph("Bill No.:").setBold())
                                    .setTextAlignment(TextAlignment.LEFT));
                            table2.addCell(new Cell().add(new Paragraph("1").setTextAlignment(TextAlignment.LEFT)));
                            table2.addCell(new Cell()
                                    .add(new Paragraph("Mo No.:").setBold().setTextAlignment(TextAlignment.LEFT)));
                            table2.addCell(new Cell().add(new Paragraph(mo_no).setTextAlignment(TextAlignment.LEFT)));
                            table2.addCell(
                                    new Cell().add(new Paragraph("Date:").setBold().setTextAlignment(TextAlignment.LEFT)));
                            table2.addCell(new Cell().add(new Paragraph(strDate).setTextAlignment(TextAlignment.LEFT)));
                            document.add(table2);

                            // table 3
                            float[] dimension = { 50F, 300F, 60F, 60F, 60F };
                            Table table3 = new Table(dimension);

                            table3.addCell(new Cell().add("Sr. No").setBackgroundColor(Color.LIGHT_GRAY)
                                    .setTextAlignment(TextAlignment.CENTER));
                            table3.addCell(new Cell().add("Products").setBackgroundColor(Color.LIGHT_GRAY)
                                    .setTextAlignment(TextAlignment.CENTER));
                            table3.addCell(new Cell().add("Quantity").setBackgroundColor(Color.LIGHT_GRAY)
                                    .setTextAlignment(TextAlignment.CENTER));
                            table3.addCell(new Cell().add("Price").setBackgroundColor(Color.LIGHT_GRAY)
                                    .setTextAlignment(TextAlignment.CENTER));
                            table3.addCell(new Cell().add("Amount").setBackgroundColor(Color.LIGHT_GRAY)
                                    .setTextAlignment(TextAlignment.CENTER));

                            Selected_product ptr_pdf = catalogue_head;
                            double total = 0;
                            int sr_no = 1;
                            while (ptr_pdf != null) {
                                total += ptr_pdf.price * ptr_pdf.Qauntity;
                                table3.addCell(
                                        new Cell().add(String.valueOf(sr_no)).setTextAlignment(TextAlignment.CENTER));
                                table3.addCell(new Cell().add(ptr_pdf.Product_name.toUpperCase())
                                        .setTextAlignment(TextAlignment.LEFT));
                                table3.addCell(new Cell().add(String.valueOf(ptr_pdf.Qauntity))
                                        .setTextAlignment(TextAlignment.CENTER));
                                table3.addCell(new Cell().add(String.valueOf(ptr_pdf.price))
                                        .setTextAlignment(TextAlignment.CENTER));
                                table3.addCell(new Cell().add(String.valueOf(ptr_pdf.Qauntity * ptr_pdf.price))
                                        .setTextAlignment(TextAlignment.RIGHT));
                                sr_no++;
                                ptr_pdf = ptr_pdf.next;
                            }
                            document.add(table3);

                            // table 4
                            float dimension1[] = { 470f, 60f };
                            Table table4 = new Table(dimension1);

                            table4.addCell(new Cell().add("TOTAL").setTextAlignment(TextAlignment.CENTER).setBold());
                            table4.addCell(
                                    new Cell().add(String.valueOf(total)).setTextAlignment(TextAlignment.RIGHT).setBold());

                            for (int i = 0; i < 10; i++)
                                table4.addCell(new Cell().add(" ").setBorder(Border.NO_BORDER));

                            document.add(table4);

                            Paragraph pr2 = new Paragraph("STATUS : PAID");
                            pr2.setFontColor(Color.RED).setTextAlignment(TextAlignment.RIGHT).setBold();
                            document.add(pr2);

                            Paragraph pr3 = new Paragraph(
                                    "\n\nNote\n1. Sold items are not acceptable here...\n2. Items will Exchangable within after 2 days of purchasing.\n");
                            document.add(pr3.setBold());

                            Paragraph pr4 = new Paragraph("\n\n\n- - - - - THANK YOU FOR VISITING - - - - -");
                            document.add(pr4.setBold().setTextAlignment(TextAlignment.CENTER));
                            document.close();
                            sc.close();
                            break;

                        } else if (payment < Amount) {
                            System.out.println(
                                    "\n\t\t\t\t\t\t\tPayment Unsuccessful...\n\t\t\t\t\t\t\tPress 1: Repeat payment\n\t\t\t\t\t\t\tPress 2: Exit\n\t\t\t\t\t\t\tEnter here: ");
                            int op = sc.nextInt();
                            if (op == 1) {
                                continue;
                            } else {
                                System.out.println("\n\t\t\t\t\t\t\t... THANK YOU FOR VISITING ...\n");
                                break;
                            }
                        }
                    }
                    sc.close();
                    System.exit(0);
                }
                break;
            }
        }
    }
}