using HangmanGame.Letter;
using HangmanGame.Letters;
using HangmanGame.WordSource;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Linq;

namespace HangmanGameTests.Letters
{
    [TestClass]
    public class InitialLettersTests
    {
        [TestMethod]
        public void ShowTest()
        {
            RandomWord rw = new RandomWord(5, 20);
            string test = rw.Word();
            ConcreteWordSource cws = new ConcreteWordSource(test);
            InitialLetters guessedLetters = new InitialLetters(cws);
            ILetter[] reference = test.Select(x => new HiddenLetter(x)).ToArray();

            ILetter[] shown = guessedLetters.Show();

            CollectionAssert.AreEqual(reference, shown, new LetterComparer());
        }

        [TestMethod]
        public void HiddensCountTest()
        {
            RandomWord rw = new RandomWord(5, 20);
            string test = rw.Word();
            ConcreteWordSource cws = new ConcreteWordSource(test);
            InitialLetters guessedLetters = new InitialLetters(cws);

            Assert.AreEqual(guessedLetters.HiddensCount(), test.Length);
        }
    }
}
