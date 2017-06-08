using System;
using System.IO;
using System.Collections.Generic;
using System.Text;
using Xunit;

namespace Hangman
{
    public class ProgramTests
    {
        [Fact]
        public void Method()
        {
            var output = new MemoryStream();
            new Program(
                new MemoryStream(
                    Encoding.ASCII.GetBytes("a\na\na\na\na\n")
                ), 
                output, 
                1
            ).Exec();
            Assert.Contains(
                        "You lost", 
                        Encoding.ASCII.GetString(output.ToArray())
                    );
        }
    }
}
