package com.example.wefish;

import com.example.fishingapp.R;

import java.util.ArrayList;

public class Fish {

    private int img;
    private String name;
    private String info;

    public Fish(int img, String name, String info) {
        this.img = img;
        this.name = name;
        this.info = info;
    }


    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }



    public static ArrayList<Fish> fillFishList(){
        ArrayList fishList = new ArrayList();
        fishList.add(new Fish(R.drawable.octopus, "Octopus(Ahtapot)", "Latin: Octopus vulgaris \nLimit:1 kg  \nClose Season(Av Yasağı Dönemi):15.04 - 31.06" ));
        fishList.add(new Fish(R.drawable.akya, "Amberjack(Akya)" , "Latin: Seriola Dumerili.\nLimit :30cm  \nClose Season(Av Yasağı Dönemi): 15.04-31.08"));
        fishList.add(new Fish(R.drawable.barracuda, "Barracuda(Baraküda)", "Latin: Sphyraena sphyraena \nLimit: - \nClose Season(Av Yasağı Dönemi): - \n"));
        fishList.add(new Fish(R.drawable.redmullet, "Red Mullet(Barbun)", "Latin: Mullus Barbatus \nLimit: 13 cm \nClose Season(Av Yasağı Dönemi): 15.04-31.08\n"));
        fishList.add(new Fish(R.drawable.fenerbaligi, "Angler Fish(Fener Balığı)", "Latin: \nLimit: -\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.glotchgrouper, "Goldblotch Grouper(Grida)", "Latin: \nLimit: 45 cm\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.anchovy, "Anchovy(Hamsi)", "Latin: ngraulis encrasicolus\nLimit: 9cm\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.blackscorpfish, "Black Scorpion Fish(İskorpit)", "Latin: Scorpaena porcus \nLimit: -\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.horsemackarel, "Horse Mackerel(İstavrit)", "Latin: Trachurus trachurus \nLimit: -\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.squid, "Squid(Kalamar)", "Latin: \nLimit: -\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.turbot, "Turbot(Kalkan)", "Latin: \nLimit: -\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.shrimp, "Shrimp(Karides)", "Latin: \nLimit: -\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.mullet, "Mullet(Kefal)", "Latin): Mugil cephalus \nLimit: 20cm\nClose Season(Av Yasağı Dönemi): - \n"));
        fishList.add(new Fish(R.drawable.swordfish, "Sword Fish(Kılıç)", "Latin: Xiphias gladius \nLimit: 130 cm/ \nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.bouge, "Bogue(Gopez)", "LatinBoops boops \nLimit: - \n Close Season(Av Yasağı Dönemi): -"));
        fishList.add(new Fish(R.drawable.whitegrouper, "White Grouper(Lağos)", "LatinEpinephelus aeneus \nLimit: -\nClose Season(Av Yasağı Dönemi):15.04 - 31.06"));
        fishList.add(new Fish(R.drawable.seabass, "Seabass(Levrek)", "Latin: Dicentrarchus labrax \nLimit: 30 cm\nClose Season(Av Yasağı Dönemi): -"));
        fishList.add(new Fish(R.drawable.bluefish, "Bluefish(Lüfer)", "Latin:Pomatomus saltator \nLimit: 14 cm \nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.saddledseabream, "Saddled Seabream(Melenur)", "Latin:Oblada melanura \nLimit: -\nClose Season(Av Yasağı Dönemi): - \n"));
        fishList.add(new Fish(R.drawable.pandora, "Common Pandora(Mercan)", "Latin:Pagellus erythrinus \nLimit: 15 cm \nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.stripedseabream, "Sand steenbras(Mırmır)", "Latin: \nLimit: -\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.bonito, "Bonito(Palamut)", "Latin: Sarda sarda\nLimit: 25cm\nClose Season(Av Yasağı Dönemi): \nu"));
        fishList.add(new Fish(R.drawable.pilchard, "Pilchard(Sardalya)", "Latin:Sardina pilchardus \nLimit: 11 cm\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.whiteseabream, "White Seabream(Sargoz)", "Latin: Diplodus sargus\nLimit: 21 cm \nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.dentex, "Dentex(Sinarit)", "Latin: Dentex dentex \nLimit:35 cm\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.cuttlefish, "Cuttlefish(Sübye)", "Latin: Sepia officinalis \nLimit: -\nClose Season(Av Yasağı Dönemi): -\n"));
        fishList.add(new Fish(R.drawable.grouper, "Grouper(Orfoz)", "Latin: Epinephelus marginatus \nLimit:45 cm\nIts hunting is prohibited because it is endangered.\n "));
        fishList.add(new Fish(R.drawable.needlefish, "Needle Fish(Zargana)", "Latin: Belone belone \nLimit: -\nClose Season(Av Yasağı Dönemi): -  \n"));

        return fishList;
    }

    public static Fish getFish(int i){
        return fillFishList().get(i);
    }
}
