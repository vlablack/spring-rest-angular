package org.library.rest.api.component.author.service.impl;

import org.library.rest.api.common.service.GenericCRUDServiceImpl;
import org.library.rest.api.component.author.service.AuthorService;
import org.library.rest.api.domain.Author;
import org.library.rest.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends GenericCRUDServiceImpl<Author> implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    protected JpaRepository<Author, Long> getRepository() {
        return authorRepository;
    }
}
