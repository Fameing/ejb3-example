package com.mydomain;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.Date;

@Stateless(name = "HelloSessionBean", mappedName = "ejb/HelloSessionBean")
@Local( HelloSessionBeanLocal.class  )
@Remote( HelloSessionBeanRemote.class )
public class HelloSessionBean implements HelloSessionBeanLocal, HelloSessionBeanRemote  {
    public Date getTime() {
        return new Date();
    }
}
