using HangmanGame.Hangman;
using HangmanGame.Letters;
using HangmanGame.Word;
using HangmanGame.WordSource;
using HangmanGameTests;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.IO;
using System.Linq;

namespace HangmanGame.Game.Tests
{
    [TestClass()]
    public class GameTests
    {
        [TestMethod()]
        public void CanLost()
        {
            string l = Environment.NewLine;
            char i = ' '; // incorrect char
            using (TextReader tr = new StringReader($"{i}{l}{i}{l}{i}{l}{i}{l}{i}{l}"))
            {
                using (TextWriter tw = new StringWriter())
                {
                    RandomWord rw = new RandomWord(5, 20);
                    string test = rw.Word();

                    Game game = new Game(new AliveHangman(new TargetWord(new InitialLetters(new ConcreteWordSource(test))), 5), tr, tw);

                    game.Start();

                    string result = tw.ToString();
                    bool lost = result.Contains("You lost.");

                    Assert.IsTrue(lost);
                }
            }
        }

        [TestMethod()]
        public void CanWin()
        {
            string l = Environment.NewLine;
            RandomWord rw = new RandomWord(5, 20);
            string test = rw.Word();
            string rightInputs = string.Join(l, test.Distinct().Select(x => x.ToString())) + l;

            using (TextWriter tw = new StringWriter())
            {
                using (TextReader tr = new StringReader(rightInputs))
                {
                    Game game = new Game(new AliveHangman(new TargetWord(new InitialLetters(new ConcreteWordSource(test))), 5), tr, tw);

                    game.Start();

                    string result = tw.ToString();
                    bool won = result.Contains("You won");

                    Assert.IsTrue(won);
                }
            }
        }
    }
}