/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 */
package hangman;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public final class MainTest {

    @Test
    public void failsAfterManyWrongAttempts() throws Exception {
        final ByteArrayInputStream input = new ByteArrayInputStream(
            "a\na\na\na\na\n".getBytes()
        );
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        new Main(input, output, 1).exec();
        assertThat(output.toString(), containsString("You lost"));
    }

}
