package Users;

import Visitor.Visitor;

public interface Visitable {
    int accept(Visitor v);
}
