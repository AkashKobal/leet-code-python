class Solution {
    public boolean judgePoint24(int[] cards) {
        ArrayList<Double> cardArray = new ArrayList<>();
        for (int card : cards) {
            cardArray.add((double) card);
        }
        return getJudgePoint24(cardArray);
    }

    public boolean getJudgePoint24(ArrayList<Double> cardArray) {
        boolean is24 = false;
        if(cardArray.size() == 1 && (cardArray.get(0) - 24) < 0.001 && (cardArray.get(0) - 24) > -0.001) {
            is24 = true;
        }
        if(cardArray.size() > 1) {
            for(int i = 0; i < cardArray.size(); i++) {
                for(int j = i+1; j < cardArray.size(); j++) {
                    ArrayList<Double> newCardsArray = new ArrayList<>(cardArray);
                    Double card1 = cardArray.get(i);
                    Double card2 = cardArray.get(j);
                    newCardsArray.remove(card1);
                    newCardsArray.remove(card2);

                    ArrayList<Double> newCardsWithOperation = new ArrayList<>(newCardsArray);
                    newCardsWithOperation.add(card1+card2);
                    if(getJudgePoint24(newCardsWithOperation)) {
                        return true;
                    };

                    newCardsWithOperation.clear();
                    newCardsWithOperation.addAll(newCardsArray);
                    newCardsWithOperation.add(card1-card2);
                    if(getJudgePoint24(newCardsWithOperation)) {
                        return true;
                    };

                    newCardsWithOperation.clear();
                    newCardsWithOperation.addAll(newCardsArray);
                    newCardsWithOperation.add(card2-card1);
                    if(getJudgePoint24(newCardsWithOperation)) {
                        return true;
                    };

                    newCardsWithOperation.clear();
                    newCardsWithOperation.addAll(newCardsArray);
                    newCardsWithOperation.add(card2*card1);
                    if(getJudgePoint24(newCardsWithOperation)) {
                        return true;
                    };

                    if(card1 != 0) {
                        newCardsWithOperation.clear();
                        newCardsWithOperation.addAll(newCardsArray);
                        newCardsWithOperation.add(card2/card1);
                        if(getJudgePoint24(newCardsWithOperation)) {
                            return true;
                        };
                    }

                    if(card2 != 0) {
                        newCardsWithOperation.clear();
                        newCardsWithOperation.addAll(newCardsArray);
                        newCardsWithOperation.add(card1/card2);
                        if(getJudgePoint24(newCardsWithOperation)) {
                            return true;
                        };
                    }

                }
            }
        }
        return is24;
    }
}