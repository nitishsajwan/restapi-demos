package gfg.restapis.demorestapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class BookController {
private static final Logger logger= LoggerFactory.getLogger(BookController.class);
private  final HashMap<Integer, Book> bookHashMap=new HashMap<>();


@GetMapping("/book")
    public Book getBook(@RequestParam("id") int bookID){
    logger.info("Book details - {}", bookHashMap.get(bookID));
    return bookHashMap.get(bookID);
}

    @GetMapping("/book/all")
    public List<Book> getAllBooks(){

        return bookHashMap.values().stream().toList();
    }

    @GetMapping("/book/{id}")
    public Book getBookbyID(@PathVariable("id") int bookID){
        logger.info("Book details - {}", bookHashMap.get(bookID));
        return bookHashMap.get(bookID);
    }

    @PutMapping("/book")
    public List<Book> insertBook(@RequestBody Book book, @RequestParam("id") int id ){
    bookHashMap.put(id,book);
    return bookHashMap.values().stream().toList();
    }

    @DeleteMapping("/book")
    public List<Book> deleteBook(@RequestParam("id") int id){
    bookHashMap.remove(id);
        return bookHashMap.values().stream().toList();
    }

/*@PostMapping("/book")
    public void insertBook(@RequestParam("id") Integer BookID,
                           @RequestParam("name") String name,
                           @RequestParam("cost") Integer cost,
                           @RequestParam("aName") String aName){

}*/

    @PostMapping("/book")
    public void insertBook(@RequestBody Book book){
        bookHashMap.put(book.getId(), book);
    }
}
