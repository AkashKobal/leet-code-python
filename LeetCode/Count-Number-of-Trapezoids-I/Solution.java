for (int i = 0; i < choices.size(); i++) {
    for (int j = i + 1; j < choices.size(); j++) {
        result += choices.get(i) * choices.get(j);
    }
}