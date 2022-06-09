package io.gmailClone.folders;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoldersRepository extends CassandraRepository<Folders,String> {

     List<Folders> findAllById(String id);
}
