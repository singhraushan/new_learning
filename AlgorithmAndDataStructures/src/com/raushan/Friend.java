package com.raushan;

import java.util.Collection;
import java.util.ArrayList;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    /*public boolean canBeConnected(Friend friend) {
       for(Friend tempFriend: this.getFriends()) {
    	   if(tempFriend == friend)
			   return true;
    	   for(Friend innerTempFriend: tempFriend.getFriends()) {
    		   if(innerTempFriend == friend)
				   return true;
    	   }
       }
       return false;
    }*/
  /*  public boolean canBeConnected(Friend friend) {
        for(Friend tempFriend: this.getFriends()) {
     	   if(tempFriend == friend)
 			   return true;
     	  canBeConnected(tempFriend);
        }
        return false;
     }*/

    public boolean canBeConnected(Friend friend,Friend CurrentFriend) {
           if(CurrentFriend == friend)
 			   return true;
           friend.getFriends().remove(CurrentFriend);
           canBeConnected(friend.getFriends().iterator().next(),CurrentFriend);
        return false;
     }
    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);
        
        System.out.println(a.canBeConnected(c,a));
    }
}