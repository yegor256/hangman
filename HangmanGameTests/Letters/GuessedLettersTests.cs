using HangmanGame.Letter;
using HangmanGame.Letters;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Linq;

namespace HangmanGameTests.Letters
{
    [TestClass]
    public class GuessedLettersTests
    {
        [TestMethod]
        public void ShowTest()
        {
            RandomWord rw = new RandomWord(5, 20);
            string test = rw.Word();
            ILetter[] initial = test.Select(x => new HiddenLetter(x)).ToArray();
            GuessedLetters guessedLetters = new GuessedLetters(initial);

            ILetter[] shown = guessedLetters.Show();

            CollectionAssert.AreEqual(initial, shown);
        }

        [TestMethod]
        public void HiddensCountTest()
        {
            RandomWord rw = new RandomWord(5, 20);
            string test = rw.Word();
            int index = new Random().Next(0, test.Length);
            ILetter[] initial = test.Select((e, i) => i == index ? (ILetter)new VisibleLetter(e) : new HiddenLetter(e)).ToArray();
            GuessedLetters guessedLetters = new GuessedLetters(initial);

            Assert.AreEqual(guessedLetters.HiddensCount(), test.Length - 1);
        }
    }
}
