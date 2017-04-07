import { LibraryWebuiPage } from './app.po';

describe('library-webui App', () => {
  let page: LibraryWebuiPage;

  beforeEach(() => {
    page = new LibraryWebuiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
