package hangman;

import java.util.Random;

public final class WordList
{
    private final String[] _words;

    public WordList()
    {
        this("simplicity", "equality", "grandmother", "neighborhood", "relationship", "mathematics", "university", "explanation", "adult",
                "aeroplane","air","aircraft", "carrier","airforce","airport","album","alphabet","apple","arm","army","baby","baby","backpack",
                "balloon","banana","bank","barbecue","bathroom","bathtub","bed","bed","bee","bible","bible","bird","bomb","book","boss",
                "bottle","bowl","box","boy","brain","bridge","butterfly","button","cappuccino","car","car-race","carpet","carrot","cave",
                "chair","chess", "board","chief","child","chisel","chocolates","church","church","circle","circus","circus","clock","clown",
                "coffee","coffee-shop","comet","compact", "disc","compass","computer","crystal","cup","cycle","data", "base","desk","diamond",
                "dress","drill","drink","drum","dung","ears","earth","egg","electricity","elephant","eraser","explosive","eyes","family",
                "fan","feather","festival","film","finger","fire","floodlight","flower","foot","fork","freeway","fruit","fungus","game",
                "garden","gas","gate","gemstone","girl","gloves","god","grapes","guitar","hammer","hat","hieroglyph","highway","horoscope",
                "horse","hose","ice","ice-cream","insect","jet", "fighter","junk","kaleidoscope","kitchen","knife","leather", "jacket","leg",
                "library","liquid","magnet","man","map","maze","meat","meteor","microscope","milk","milkshake","mist","money","monster",
                "mosquito","mouth","nail","navy","necklace","needle","onion","paintbrush","pants","parachute","passport","pebble","pendulum",
                "pepper","perfume","pillow","plane","planet","pocket","post-office","potato","printer","prison","pyramid","radar","rainbow",
                "record","restaurant","rifle","ring","robot","rock","rocket","roof","room","rope","saddle","salt","sandpaper","sandwich",
                "satellite","school","sex","ship","shoes","shop","shower","signature","skeleton","slave","snail","software","solid","space",
                "shuttle","spectrum","sphere","spice","spiral","spoon","sports-car","spot", "light","square","staircase","star","stomach","sun",
                "sunglasses","surveyor","swimming", "pool","sword","table","tapestry","teeth","telescope","television","tennis","racquet",
                "thermometer","tiger","toilet","tongue","torch","torpedo","train","treadmill","triangle","tunnel","typewriter","umbrella",
                "vacuum","vampire","videotape","vulture","water","weapon","web","wheelchair","window","woman","worm");
    }

    public WordList(String... words)
    {
        _words = words;
    }

    public String random()
    {
        return _words[new Random().nextInt(_words.length)];
    }
}

