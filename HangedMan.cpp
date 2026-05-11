#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>

using namespace std;

class Word {
public:
    string word_got;
    string word_bool;
    Word() {
        Word("0", "0");
    }
    Word(string a, string b) {
        word_got = a;
        word_bool = b;
    }
    void get() {
        cout << word_got << endl << word_bool << endl;
    }
};

class Lib {
private:
    string words[8] = {"simplicity", "equality", "grandmother",
        "neighborhood", "relationship", "mathematics",
        "university", "explanation"};
public:
    Word get() {
        string word_got = words[rand() % 8];
        string word_bool(word_got.size(), '0');
        return Word(word_got, word_bool);
    }
};

class Guess {
public:
    char guess;
    void get() {
        cout << "Guess a letter:" << endl;
        cin >> guess;
    }
};

class Talker {
public:
    void miss(int a, int b) {
        cout << "Missed, mistake " << b - a << " out of " << b << endl;
    }
    void hit() {
        cout << "Hit!" << endl;
    }
    void word_print() {
        cout << "The word: " << endl;
    }
    void win() {
        cout << "You won!" << endl;
    }
    void lose() {
        cout << "You lost!" << endl;
    }
    void farewell() {
        cout << "It was nice to play with you!" << endl;
    }
};

class Attempts {
private:
    int start;
    int left;
public:
    Talker speaker;
    Attempts() {
        Attempts(0);
    }
    Attempts(int a) {
        start = a;
        left = a;
    }
    int get() {
        return left;
    }
    void miss() {
        left--;
        speaker.miss(left, start);
    }
};

class Iterate {
private:
    Guess guesser;
    Lib library;
    Word our_word = library.get();
    Attempts attempt = 5;
public:
    int check(char a, Word *b, Attempts *c) {
        int i;
        bool d = false, e = false;
        for (i = 0; i < b->word_got.size(); i++) {
            if (a == b->word_got[i]) {
                d = true;
                b->word_bool[i] = '1';
            }
            if (b->word_bool[i] == '0')
                e = true;
        }
        if (d == false)
            c->miss();
        else
            c->speaker.hit();
        if (e == true)
            return 0;
        return 1;
    }
    void iteration() {
        while(attempt.get() > 0) {
            guesser.get();
            if (check(guesser.guess, &our_word, &attempt))
                break;
            show(&our_word);
        }
        if (attempt.get() > 0)
            attempt.speaker.win();
        else
            attempt.speaker.lose();
        attempt.speaker.farewell();
    }
    void show(Word *a) {
        int i;
        for (i = 0; i < a->word_got.size(); i++) {
            if (a->word_bool[i] == '1')
                cout << a->word_got[i];
            else
                cout << '?';
        }
        cout << endl;
    }
};

int main() {
    srand(time(0));
    Iterate start;
    start.iteration();
    return 0;
}
