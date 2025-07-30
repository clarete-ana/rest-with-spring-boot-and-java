package br.com.erudio.services;

import br.com.erudio.data.dto.v1.PersonDTO;
import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.exception.ResourceNotFoundException;

import static br.com.erudio.mapper.ObjectMapper.parseListObjects;
import static br.com.erudio.mapper.ObjectMapper.parseObject;

import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;


    public List<PersonDTO> findAll(){
        logger.info("Finding all people!");

        return parseListObjects(repository.findAll(), PersonDTO.class);

    }

    public PersonDTO findById(Long id){
        logger.info("Finding one Person!");

        var entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one person!");
        var entity = parseObject(person, Person.class);
        return  parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person){
        logger.info("Creating one person!");
        var entity = converter.convertDTOToEntity(person);
        return  converter.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Updating one person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return  parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Deleting one person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }


    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Some Address in Brazil");
        person.setGender("Male");
        return person;
    }
}
