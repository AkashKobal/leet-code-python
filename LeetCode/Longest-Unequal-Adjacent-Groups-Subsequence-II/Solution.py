words = ["dc","bc","dd","da"]
connections = {
    0 : [1, 2, 3] # "dc" is 1 letter apart from all of the other words
    1 : [],
    2 : [3] # words[2] and words[3] are 1 letter apart
    3 : [] # we can only connect with words ahead, so no connections for the last word
}