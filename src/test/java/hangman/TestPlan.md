                # For testing random words.
                System.out.println(words.next().letters().stream()
                    .map(l -> String.valueOf(l.symbol()))
                    .collect(Collectors.joining("")));


                # For testing letter on confirmed
                System.out.println(wasLetterOn.confirmed());


                # For testing: you hit!
                LetterOnCodition wordCondition =
                new WasLetterOn(
                        new LettersOn(
                                new CharactersAsWord(
                                        new Characters("simplicity")
                                ),
                                new WhereSymbol('i')
                        )
                );


                # For testing: you won!
                LetterOnCodition wordCondition =
                     new WasLetterOn(
                             new LettersOn(new WhereSymbol('i'),
                                     new CharactersAsWord(
                                             new Characters(
                                                     "iiii"))));


                # For testing: you missed it!
                LetterOnCodition wordCondition =
                new WasLetterOn(
                        new LettersOn(
                                new CharactersAsWord(
                                        new Characters("simplicity")
                                ),
                                new WhereSymbol('a')
                        )
                );
 