using HangmanGame.Hangman;
using System;
using System.IO;

namespace HangmanGame.Game
{
    public class Game
    {
        private IHangman _hangman;
        private TextReader _tr;
        private TextWriter _tw;

        public Game(IHangman hangman, TextReader tr, TextWriter tw)
        {
            _hangman = hangman;
            _tr = tr;
            _tw = tw;
        }

        public void Start()
        {
            _tw.WriteLine(_hangman.Tell());
            while (_hangman.CanPlay())
            {
                string raw = _tr.ReadLine();
                char guess = raw.Length > 0 ? raw[0] : ' ';
                _tw.WriteLine($"Your guess is: '{guess}'");
                _hangman = _hangman.Step(guess);

                _tw.WriteLine(_hangman.Tell());
                _tw.WriteLine("***************");
            }
            _tw.WriteLine("Press any key to exit");
            _tr.ReadLine();
        }
    }
}
