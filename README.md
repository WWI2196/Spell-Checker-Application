# Part B - Spell-Checker Application

## Overview
This part of the assessment involves the implementation of a spell-checker application. The application stores a lexicon of words in a set and implements a method `spellChecker(a)` to perform spell checks on strings against the set of words.

## Functionalities
- `spellChecker(a)`: Checks the spelling of the string `a` against the lexicon `Y`. If `a` is in `Y`, it returns a list containing only `a`. Otherwise, it returns a list of words from `Y` that might be correct spellings of `a`.

## Error Handling
The program accounts for common misspellings by:
- Swapping adjacent characters in a word
- Inserting a single character between two adjacent characters
- Deleting a single character from a word
- Replacing a character in a word with another character

