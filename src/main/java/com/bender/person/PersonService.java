package com.bender.person;

import com.bender.SortingOrder;
import com.bender.exception.DuplicateResourceException;
import com.bender.exception.ResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final FakePersonRepository fakePersonRepository;
    private final PersonRepository personRepository;

    public PersonService(FakePersonRepository fakePersonRepository, PersonRepository personRepository) {
        this.fakePersonRepository = fakePersonRepository;
        this.personRepository = personRepository;
    }

    public List<Person> getPeople(SortingOrder sort) {
        return personRepository.findAll(Sort.by(Sort.Direction.valueOf(sort.name()), "id"));
    }

    public Person getPersonById(Integer id) {
        return personRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Person with id " + id + " does not exist!"));
    }

    public void deletePersonById(Integer id) {
        boolean exist = personRepository.existsById(id);
        if (!exist) {
            throw new ResourceNotFoundException("Person with id " + id + " does not exist!");
        }
        personRepository.deleteById(id);
    }

    public void addPerson(NewPersonRequest personRequest
    ) {
        if (personRequest.email() != null && !personRequest.email().isEmpty()) {
            boolean emailTaken = personRepository.existsByEmail(personRequest.email());
            if (emailTaken) {
                throw new DuplicateResourceException("Person with email " + personRequest.email() + " already exists!");
            }
        }
        Person person = new Person(
                personRequest.name(),
                personRequest.age(),
                personRequest.gender(),
                personRequest.email()
        );
        personRepository.save(person);
    }

    public void updatePerson(Integer id,
                             PersonUpdateRequest request) {
        Person person = personRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Person with id " + id + " does not exist!"));

        person.setName(request.name());
        person.setAge(request.age());

        personRepository.save(person);
    }

}
