package org.library.rest.api.component.author.controller;

import org.library.rest.api.common.controller.GenericCRUDController;
import org.library.rest.api.common.service.GenericCRUDService;
import org.library.rest.api.component.author.service.AuthorService;
import org.library.rest.api.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(AuthorController.BASE_URL)
public class AuthorController extends GenericCRUDController<Author> {

    static final String BASE_URL = "/authors";

    @Autowired
    private AuthorService authorService;

    @Override
    protected GenericCRUDService<Author> getService() {
        return authorService;
    }

    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }
}
