package csc202.FinalProject.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UserChainedComparator implements Comparator<User> {
    private List<Comparator<User>> listComparators;

    public UserChainedComparator(Comparator<User>...comparators){
        this.listComparators = Arrays.asList(comparators);
    }

    public int compare(User u1, User u2){
        for(Comparator<User> comparator:listComparators){
            int result = comparator.compare(u1, u2);
            if(result!=0)
                return result;

        }
        return 0;
    }
}
