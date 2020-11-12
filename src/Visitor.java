// I recognize fully that my visitor pattern is an unnecessary complication and could have much more easily been solved
// if all stats were localized under Admin (like they were before) or if I had simply made all the methods that return
// the stats static, but then I wouldn't have a visitor pattern, would I?

public interface Visitor {
    int getCount(Visitable v);
}
