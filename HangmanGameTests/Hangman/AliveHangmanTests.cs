using Microsoft.VisualStudio.TestTools.UnitTesting;
using HangmanGame.Hangman;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HangmanGame.Word;
using HangmanGame.Letters;
using HangmanGame.WordSource;
using HangmanGameTests;
using HangmanGame.GuessStep;
using HangmanGame.Letter;

namespace HangmanGame.Hangman.Tests
{
    [TestClass()]
    public class AliveHangmanTests
    {
        private Random rnd = new Random();
        private int RandomVal => rnd.Next(2, 10);

        [TestMethod()]
        public void WonStepTest()
        {
            RandomWord rw = new RandomWord(5, 20);
            string test = rw.Word();
            char correctGuess = test[rnd.Next(0, test.Length)];
            ILetters letters = new GuessedLetters(test.Select(x => x == correctGuess ? (ILetter)new HiddenLetter(x) : new VisibleLetter(x)).ToArray());
            AliveHangman hangman = new AliveHangman(new TargetWord(letters), RandomVal);

            IHangman result = hangman.Step(correctGuess);

            Assert.IsInstanceOfType(result, typeof(WonHangman));
        }

        [TestMethod()]
        public void DeadStepTest()
        {
            RandomChar rc = new RandomChar();
            int maxAttempts = 0;
            AliveHangman hangman = HangmanFactory(maxAttempts, out string test);

            IHangman result = hangman.Step(rc.GetAnother(test.ToCharArray()));

            Assert.IsInstanceOfType(result, typeof(DeadHangman));
        }

        [TestMethod()]
        public void StepTest()
        {
            RandomChar rc = new RandomChar();
            AliveHangman hangman = HangmanFactory(RandomVal, out string test);

            IHangman result = hangman.Step(rc.Load());

            Assert.IsInstanceOfType(result, typeof(AliveHangman));
        }

        [TestMethod()]
        public void CanPlayTest()
        {
            AliveHangman hangman = HangmanFactory(RandomVal, out _);

            Assert.IsTrue(hangman.CanPlay());
        }

        [TestMethod()]
        public void TellTest()
        {
            RandomChar rc = new RandomChar();
            int maxAttempts = RandomVal;
            AliveHangman hangman = HangmanFactory(maxAttempts, out string test);

            char correct = test[rnd.Next(0, test.Length)];
            char incorrect = rc.GetAnother(test.ToCharArray());


            IHangman hangmanGuess1 = hangman.Step(correct);
            IHangman hangmanGuess2 = hangmanGuess1.Step(incorrect);

            string start = hangman.Tell();
            string success = hangmanGuess1.Tell();
            string fail = hangmanGuess2.Tell();

            Assert.AreEqual(start, "Guess a letter: ");
            Assert.IsTrue(success.StartsWith("Hit! "));
            Assert.IsTrue(fail.StartsWith($"Missed, mistake 1 out of {maxAttempts}"));
        }

        private AliveHangman HangmanFactory(int maxAttempts, out string test)
        {
            RandomWord rw = new RandomWord(5, 20);
            test = rw.Word();
            AliveHangman hangman = new AliveHangman(new TargetWord(new InitialLetters(new ConcreteWordSource(test))), maxAttempts);
            return hangman;
        }
    }
}