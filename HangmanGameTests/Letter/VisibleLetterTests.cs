using HangmanGame.Letter;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace HangmanGameTests.Letter
{
    [TestClass]
    public class VisibleLetterTests
    {
        [TestMethod]
        public void ReturnCorrectValue()
        {
            RandomChar rc = new RandomChar();
            char target = rc.Load();
            VisibleLetter letter = new VisibleLetter(target);

            char val = letter.Value();

            Assert.AreEqual(target, val);
        }

        [TestMethod]
        public void PrintCorrectValue()
        {
            RandomChar rc = new RandomChar();
            char target = rc.Load();
            VisibleLetter letter = new VisibleLetter(target);

            char val = letter.Print();

            Assert.AreEqual(target, val);
        }

        [TestMethod]
        public void ValueAlreadyOpenedInAnyCase()
        {
            RandomChar rc = new RandomChar();
            char target = rc.Load();
            char incorrect = rc.GetAnother(target);
            VisibleLetter letter = new VisibleLetter(target);

            ILetter success = letter.Open(target);
            ILetter fail = letter.Open(incorrect);

            Assert.IsFalse(success.Hidden());
            Assert.IsFalse(fail.Hidden());

            Assert.AreEqual(target, success.Value());
            Assert.AreEqual(target, fail.Value());
        }

        [TestMethod]
        public void IsNotHidden()
        {
            RandomChar rc = new RandomChar();
            char target = rc.Load();
            VisibleLetter letter = new VisibleLetter(target);

            bool hidden = letter.Hidden();

            Assert.IsFalse(hidden);
        }
    }
}
