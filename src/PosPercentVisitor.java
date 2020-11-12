public class PosPercentVisitor implements Visitor {
    @Override
    public int getCount(Visitable v) {
        PosTweets posWords = (PosTweets) v;
        return posWords.posProportion();
    }
}
