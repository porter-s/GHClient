package ru.example.user.githubclient.creators;


import ru.example.user.githubclient.abstracts.ObjectUserAbs;
import ru.example.user.githubclient.abstracts.ObjectUserCreatorAbs;
import ru.example.user.githubclient.objects.ObjectUser;

/**
 * Created by user on 29.01.15.
 */
public class UserCreator extends ObjectUserCreatorAbs
{

    @Override
    public ObjectUserAbs create() {

        ObjectUser localObjectUser = new ObjectUser();

        return localObjectUser;
    }
}
