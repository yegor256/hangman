using Microsoft.VisualStudio.TestTools.UnitTesting;
using HangmanGame.Word;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HangmanGame.Letters;
using HangmanGame.WordSource;
using HangmanGame.Letter;
using HangmanGame.GuessStep;
using HangmanGameTests;

namespace HangmanGame.Word.Tests
{
    [TestClass()]
    public class TargetWordTests
    {
        [TestMethod()]
        public void PrintTest()
        {
            RandomWord rw = new RandomWord(5, 20);
            string test = rw.Word();
            string questions = string.Concat(test.Select(x => '?'));
            TargetWord invisible = CreateInvisible(test);
            TargetWord visible = CreateVisible(test);

            string invisibleStr = string.Concat(invisible.Print());
            string visibleStr = string.Concat(visible.Print());

            Assert.AreEqual(test, visibleStr);
            Assert.AreEqual(questions, invisibleStr);
        }

        [TestMethod()]
        public void GuessLetterTest()
        {
            RandomChar rc = new RandomChar();
            RandomWord rw = new RandomWord(5, 20);
            string test = rw.Word();
            TargetWord tw = CreateInvisible(test);
            char correct = test[0];
            char incorrect = rc.GetAnother(test.ToCharArray());

            IGuessStep fail = tw.GuessLetter(incorrect);
            IGuessStep success = tw.GuessLetter(correct);

            Assert.IsInstanceOfType(fail, typeof(FailStep));
            Assert.IsInstanceOfType(success, typeof(SuccessStep));
        }

        [TestMethod()]
        public void VisibleTest()
        {
            RandomWord rw = new RandomWord(5, 20);
            string test = rw.Word();
            TargetWord invisible = CreateInvisible(test);
            TargetWord visible = CreateVisible(test);

            Assert.IsFalse(invisible.Visible());
            Assert.IsTrue(visible.Visible());
        }

        private TargetWord CreateVisible(string test)
        {
            ILetter[] letters = test.Select(x => new VisibleLetter(x)).ToArray();
            GuessedLetters gl = new GuessedLetters(letters);

            return new TargetWord(gl);
        }

        private TargetWord CreateInvisible(string test)
        {
            InitialLetters il = new InitialLetters(new ConcreteWordSource(test));

            return new TargetWord(il);
        }
    }
}