using HangmanGame.Letter;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace HangmanGameTests.Letter
{
    [TestClass]
    public class HiddenLetterTests
    {
        private const char _questionMark = '?';

        [TestMethod]
        public void ReturnCorrectValue()
        {
            RandomChar rc = new RandomChar();
            char target = rc.Load();
            HiddenLetter letter = new HiddenLetter(target);

            char val = letter.Value();

            Assert.AreEqual(target, val);
        }

        [TestMethod]
        public void DontPrintValue()
        {
            RandomChar rc = new RandomChar();
            char target = rc.Load();
            HiddenLetter letter = new HiddenLetter(target);

            char val = letter.Print();

            Assert.AreNotEqual(target, val);
            Assert.AreEqual(_questionMark, val);
        }

        [TestMethod]
        public void CanOpenValue()
        {
            RandomChar rc = new RandomChar();
            char target = rc.Load();
            char incorrect = rc.GetAnother(target);
            HiddenLetter letter = new HiddenLetter(target);

            ILetter success = letter.Open(target);
            ILetter fail = letter.Open(incorrect);

            Assert.IsFalse(success.Hidden());
            Assert.IsTrue(fail.Hidden());

            Assert.AreEqual(target, success.Value());
            Assert.AreEqual(target, fail.Value());
            Assert.AreEqual(_questionMark, fail.Print());
        }

        [TestMethod]
        public void IsHidden()
        {
            RandomChar rc = new RandomChar();
            char target = rc.Load();
            HiddenLetter letter = new HiddenLetter(target);

            bool hidden = letter.Hidden();

            Assert.IsTrue(hidden);
        }
    }
}
