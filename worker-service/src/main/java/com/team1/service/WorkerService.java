package com.team1.service;


import com.team1.dto.response.WorkerListResponse;
import com.team1.mapper.IWorkerMapper;
import com.team1.rabbitmq.model.AuthWorkerModel;
import com.team1.rabbitmq.model.CompanyWorkerTokenModel;
import com.team1.repository.IWorkerRepository;
import com.team1.repository.entity.Worker;
import com.team1.utility.JwtTokenManager;
import com.team1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkerService extends ServiceManager<Worker, Long>{

    private final JwtTokenManager jwtTokenManager;
    private final IWorkerRepository workerRepository;

    public WorkerService(IWorkerRepository workerRepository, JwtTokenManager jwtTokenManager) {
        super(workerRepository);
        this.jwtTokenManager = jwtTokenManager;
        this.workerRepository = workerRepository;
    }




    public List<WorkerListResponse> findAllWorker(Long token) {
        //List<Worker> workerList=workerRepository.findAll();
        List<Worker> workerList=workerRepository.workerInformation(token);
        return workerList.stream().map(x->IWorkerMapper.INSTANCE.toWorkerList(x)).collect(Collectors.toList());
    }

//    public List<CompanyListenerResponseDto> findAllCompany() {
//        List<Company> companyList=findAll();
//        return  companyList.stream()
//                .map(x->ICompanyMapper.INSTANCE.toCompanyListener(x)).collect(Collectors.toList());
//    }

    public void createAuthWorker(AuthWorkerModel model) {
        Worker worker = Worker.builder().authId(model.getAuthId()).companyId(model.getCompanyId()).
        username(model.getUsername()).email(model.getEmail()).lastName(model.getLastName()).
        firstName(model.getFirstName()).phone(model.getPhone()).address(model.getAddress()).build();
        save(worker);
    }

    public List<Worker> findAllWorker12(CompanyWorkerTokenModel model) {
        //Optional<Worker> worker = workerRepository.findById(model.getCompanyId());
        List<Worker> worker = workerRepository.findAllByCompanyId(model.getCompanyId());
        return worker;
    }

//    public void workerListener(CompanyWorkerTokenModel model) {
//        Long companyId = model.getCompanyId();
//        List<String> workerList = workerRepository.workerInformation(companyId);
//        //burası zaten listeleme yapıyordu
//        //workerList.forEach(System.out::println);
//    }

    //    public List<CompanyListenerResponseDto> findAllCompany() {
    //        List<Company> companyList=findAll();
    //        return  companyList.stream()
    //                .map(x->ICompanyMapper.INSTANCE.toCompanyListener(x)).collect(Collectors.toList());
    //    }

    //yeni serviste burada düzenlemeler olabilir
//    public Boolean createWorkerUser(String token, WorkerDto dto){
//        String companyId = jwtTokenManager.getCompanyIdFromToken(token).orElseThrow(() -> {
//            throw new CompanyException(ErrorType.INVALID_TOKEN);
//        });
//        Long authId = jwtTokenManager.getIdFromToken(token).orElseThrow(() -> {
//            throw new CompanyException(ErrorType.INVALID_TOKEN);
//        });
//        Worker worker = Worker.builder().authId(authId).username(dto.getUsername())
//                .password(dto.getPassword()).email(dto.getEmail()).build();
//        //auth tablosuna kayıt eklenmedi!!!!
//        save(worker);
//        List<String> id = new ArrayList<>();
//        if (company.getId().equals(companyId)) {//bu metot olmasa da olabilir.
//
//        }
//        id.add(worker.getId());
//        company.setWorkers(id);
//        return true;
//    }
//
//    public List<Worker> findAllWorker() {
//        return workerRepository.findAll();
//    }
//
//    public Boolean deleteWorker(String token, String workerId){//workerId frontand tarafından alınacak
//        String companyId = jwtTokenManager.getCompanyIdFromToken(token).orElseThrow(() -> {
//            throw new CompanyException(ErrorType.INVALID_TOKEN);
//        });
//        Optional<Worker> worker = workerRepository.findById(workerId);
//        if (worker.get().getCompanyId().equals(companyId)) {
//            workerRepository.delete(worker.get());
//            return true;
//        }
//        return false;
//    }

//-----------------Update İşlemleri Fazla olduğu için beklemeye alındı
//
//
//    public Worker updateWorker(String id, UpdateWorkerRequestDto dto){
//        Worker worker = workerRepository.findById(id)
//                .orElseThrow(() -> new WorkerException(ErrorType.WORKER_NOT_FOUND));
//        worker.setFirstName(dto.getFirstName());
//        worker.setLastName(dto.getLastName());
//        worker.setPassword(dto.getPassword());
//        worker.setPhone(dto.getPhone());
//        worker.setAddress(dto.getAddress());
//        return workerRepository.save(worker);
//    }

//    public Post updateWorker(String token, String workerId, UpdateWorkerRequestDto dto){
//        Optional<Long> authId = jwtTokenProvider.getIdFromToken(token);
//        authId.orElseThrow(() -> new PostManagerException(ErrorType.INVALID_TOKEN));
//
//        UserProfileResponseDto userProfile = userProfileManager.findByUserProfileDto(authId.get()).getBody();
//        Optional<Post> post = postRepository.findById(postId);
//        if (userProfile.getUserId().equals(post.get().getUserId())){
//            dto.getAddMediaUrls().forEach(x -> post.get().getMediaUrls().add(x));
//            //post.get().getMediaUrls().addAll(dto.getAddMediaUrls());
//            post.get().getMediaUrls().removeAll(dto.getRemoveMediaUrls());
//            post.get().setContent(dto.getContent());
//            return update(post.get());
//        }
//        throw new PostManagerException(ErrorType.POST_NOT_FOUND);
//    }




}
